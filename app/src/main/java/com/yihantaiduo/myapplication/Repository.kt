package com.yihantaiduo.myapplication

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

object Repository {
    fun getUser(userId:String):LiveData<User>{
        val LiveData = MutableLiveData<User>()
        LiveData.value = User(userId,userId,0)
        return LiveData
    }
}