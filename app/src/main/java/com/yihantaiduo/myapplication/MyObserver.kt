package com.yihantaiduo.myapplication

import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent

class MyObserver :LifecycleObserver {
    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun activityStart(){
        Log.e("TAG", "activityStart: ", )
    }
    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun activiryStop(){
        Log.e("TAG", "activiryStop: ", )
    }
}