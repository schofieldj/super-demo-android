#include "jniapi.hpp"

#include <jni.h>
#include <android/log.h>

JNIEXPORT void JNICALL Java_com_schofield_android_apps_gamedemo_GameService_nativeBeginGame(JNIEnv* jenv, jobject obj) {
	__android_log_write(ANDROID_LOG_INFO, "jniapi.cpp", "nativeBeginGame()");
}

JNIEXPORT void JNICALL Java_com_schofield_android_apps_gamedemo_GameService_nativeEndGame(JNIEnv* jenv, jobject obj) {
	__android_log_write(ANDROID_LOG_INFO, "jniapi.cpp", "nativeEndGame()");
}

JNIEXPORT void JNICALL Java_com_schofield_android_apps_gamedemo_GameService_nativeSetSurface(JNIEnv* jenv, jobject obj, jobject surface) {
    __android_log_write(ANDROID_LOG_INFO, "jniapi.cpp", "nativeSetSurface()");
}
