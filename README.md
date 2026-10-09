# Bloodborne Android ARM64 — CI Starter

Target: Snapdragon 8 Elite / Adreno 830 (`arm64-v8a`)

## What this starter does
- Builds a **real installable Android debug APK** using GitHub Actions.
- Includes a tiny JNI native library compiled for `arm64-v8a`.
- Provides a minimal Android Activity that reports native ABI/build status.

## Important limitation
This is a **CI and Android packaging scaffold only**. It does not yet contain or run Bloodborne, FEXCore, the bbport runtime, or the Vulkan renderer. A successful APK build validates the Android toolchain/package pipeline, not game compatibility.

## Why the upstream tree cannot be built directly as an Android APK
The upstream `arm64-fex` branch is Linux-oriented:
- `gpu/CMakeLists.txt` requires X11 through pkg-config.
- The build script expects Linux pkg-config packages for Vulkan, SDL3, X11, FFmpeg and other libraries.
- The launcher/package path uses GTK4 and AppImage.
- The FEXCore integration is currently built through the Linux host build.
These need Android-specific ports/configuration before game runtime integration.

## Build locally
Open this folder in Android Studio, or run:
```bash
gradle --no-daemon assembleDebug
```
The workflow uses JDK 17 and Android SDK/NDK and uploads `app-debug.apk`.

## Next integration gates
1. Replace this scaffold with an Android-native SDL3 surface/activity path.
2. Build and test dependencies individually for Android ARM64 (SDL3, Vulkan headers/loader, FFmpeg/ATRAC9, fmt/Boost/etc.).
3. Remove or abstract X11-only code from the renderer.
4. Port FEXCore's required runtime/configuration for Android; do not assume the Linux FEX shared library is Android-compatible.
5. Add the bbport runtime and renderer only after each dependency has an Android build.
6. Add user-selected game directory access through Android's Storage Access Framework.
7. Test Vulkan device/swapchain, shader compilation, audio, controller, memory pressure, and thermal stability on-device.

Game data is not included. Use only game files you are legally entitled to use.
