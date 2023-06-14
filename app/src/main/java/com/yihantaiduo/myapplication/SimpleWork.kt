package com.yihantaiduo.myapplication

import android.content.Context
import android.content.ContextParams
import android.util.Log
import androidx.work.WorkManager
import androidx.work.Worker
import androidx.work.WorkerParameters

class SimpleWork(context: Context,params: WorkerParameters) : Worker(context,params) {
    override fun doWork(): Result {
        Log.e("TAG", "doWork: ", )
        return Result.success()
    }
}