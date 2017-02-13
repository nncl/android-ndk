#include <string.h>
#include <stdio.h>
#include <time.h>
#include <jni.h>

// Returns a String Current Date
jstring Java_com_example_rm30917_androidndk_MainActivity_getDataAtualJNI( JNIEnv* env, jobject o )
{
    time_t t = time(NULL);
    struct tm *tm = localtime(&t);
    char s[64];
    strftime(s, sizeof(s), "%c", tm);

    return (*env)->NewStringUTF(env, s);
}

// Return a sum between two variables

// package com_example_rm30917_androidndk;
jint JNICALL Java_com_example_rm30917_androidndk_MainActivity_somaJNI
(JNIEnv * env, jobject obj, jint value1, jint value2) {
return (value1 + value2);
}
