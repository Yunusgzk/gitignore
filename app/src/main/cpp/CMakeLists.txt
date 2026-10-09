cmake_minimum_required(VERSION 3.22.1)

project(bbport_android LANGUAGES CXX)

add_library(
bbport_android
SHARED
native-lib.cpp
)

target_compile_features(
bbport_android
PRIVATE
cxx_std_20
)

find_library(
log-lib
log
)

target_link_libraries(
bbport_android
PRIVATE
${log-lib}
)
