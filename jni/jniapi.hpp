#ifndef __JNIAPI_HPP__
#define __JNIAPI_HPP__

#include <jni.h>

#ifdef __cplusplus
extern "C" {
#endif

JNIEXPORT void JNICALL Java_com_schofield_android_apps_gamedemo_GameService_nativeBeginGame(JNIEnv* jenv, jobject obj);
JNIEXPORT void JNICALL Java_com_schofield_android_apps_gamedemo_GameService_nativeEndGame(JNIEnv* jenv, jobject obj);
JNIEXPORT void JNICALL Java_com_schofield_android_apps_gamedemo_GameService_nativeSetSurface(JNIEnv* jenv, jobject obj, jobject surface);

#ifdef __cplusplus
};
#endif

#endif
