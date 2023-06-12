package com.yihantaiduo.myapplication

import android.view.animation.Transformation
import androidx.core.content.contentValuesOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel

class MainViewModel(countReserved: Int) : ViewModel() {
    var counter = MutableLiveData<Int>()
    var userLivedata = MutableLiveData<User>()

    //    map()方法接受两个参数一个是原始的LiveData对象第二个参数是一个转换函数
    val userName: LiveData<String> = Transformations.map(userLivedata) { user ->
        "${user.firstName}${user.lastName}"
    }

    init {
        counter.value = countReserved
    }

    fun plusOne() {
        val count = counter.value ?: 0
        counter.value = count + 1
    }

    fun clear() {
        counter.value = 0
    }

    fun getuser(UserId: String): LiveData<User> {
//        这种写法无法进行观测
//        var user = Repository.getUser(UserId)
//        return user
        var userLivedatas:LiveData<User> = Transformations.switchMap(userLivedata){user->
            Repository.getUser(UserId)
        }
        return userLivedatas
    }
}