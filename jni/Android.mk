LOCAL_PATH := $(call my-dir)

include $(CLEAR_VARS)

LOCAL_MODULE    := game
LOCAL_CFLAGS    := -Wall
LOCAL_LDLIBS    := -llog -landroid -lEGL -lGLESv2

LOCAL_SRC_FILES := \
jniapi.cpp

include $(BUILD_SHARED_LIBRARY)