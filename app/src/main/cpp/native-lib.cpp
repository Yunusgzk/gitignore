#include <jni.h>
#include <string>

extern "C" JNIEXPORT jstring JNICALL
Java_org_bbport_android_MainActivity_nativeStatus(
JNIEnv* env,
jobject /* thiz */) {

#if defined(aarch64)
const char* abi = "Native ABI: arm64-v8a (AArch64)";
#else
const char* abi = "Native ABI: other";
#endif

const std::string status =
        std::string(abi)
        + "\nJNI native library loaded successfully."
        + "\nVulkan/game runtime integration: not implemented.";

return env->NewStringUTF(status.c_str());

}
