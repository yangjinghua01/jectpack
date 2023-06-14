package com.yihantaiduo.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.PersistableBundle
import android.util.Log
import androidx.work.*
import kotlinx.android.synthetic.main.activity_main2.*
import java.util.concurrent.TimeUnit
import kotlin.concurrent.thread

public class MainActivity2 :AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContentView(R.layout.activity_main2)
        val userdao:UserDao = AppDatabase.getDataBases(this).UserDao()
        val user1 = RoomUser("Tom","Brady",40)
        val user2 = RoomUser("TOm","green",11)
        addDataBtn.setOnClickListener(){
            thread {
                user1.id = userdao.insertRoomUser(user1)
                user2.id = userdao.insertRoomUser(user2)
            }
        }
        updateBtn.setOnClickListener(){
            thread {
                user1.age = 42
                userdao.updateRoomUser(user1)
            }
        }
        deleteDataBtn.setOnClickListener(){
            thread {
                userdao.deleteUser(user1)
            }
        }
        queryDataBtn.setOnClickListener(){
            thread {
                var loadUserOlderthan = userdao.loadUserOlderthan(0)
                for (user in loadUserOlderthan) {
                    Log.e("TAG", "onCreate: ==========>" + user)
                }
            }
        }
        dowork.setOnClickListener(){
            val result = OneTimeWorkRequest.Builder(SimpleWork::class.java).build()
            WorkManager.getInstance(this).enqueue(result)
        }
        WorkManager.getInstance(this).enqueue(rest)
        WorkManager.getInstance(this).enqueue(result)
//        处理复杂任务
        OneTimeWorkRequest.Builder(SimpleWork::class.java).addTag("simple").build()
//        通过tag来取消任务
        WorkManager.getInstance(this).cancelAllWorkByTag("simple")
        val result = OneTimeWorkRequest.Builder(SimpleWork::class.java).build()
//    通过id进行取消
        WorkManager.getInstance(this).cancelWorkById(result.id)
        val result1 = OneTimeWorkRequest.Builder(SimpleWork::class.java)
            .setBackoffCriteria(BackoffPolicy.LINEAR,10,TimeUnit.MINUTES)//该方法通过二，三参数来更新定时任务
            .build()

//        监听任务运行结果
        WorkManager.getInstance(this).getWorkInfoByIdLiveData(result1.id).observe(this){ it->
            if (it.state == WorkInfo.State.SUCCEEDED){
                Log.e("TAG", "onCreate: SUCCEEDED")
            }else if (it.state == WorkInfo.State.FAILED){
                Log.e("TAG", "onCreate: FAILED" )
            }
        }
    }
//    定时任务
    val result = OneTimeWorkRequest.Builder(SimpleWork::class.java).build()

//    周期定时任务
    var rest = PeriodicWorkRequest.Builder(SimpleWork::class.java,15,TimeUnit.MINUTES).build()
}