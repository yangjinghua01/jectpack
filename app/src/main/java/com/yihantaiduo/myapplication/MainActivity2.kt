package com.yihantaiduo.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.PersistableBundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main2.*
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
    }
}