package com.yihantaiduo.myapplication

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.edit
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var mainViewModel: MainViewModel;
    lateinit var sp:SharedPreferences;
    val TAG:String ="kdys"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        sp = getPreferences(Context.MODE_PRIVATE)
        val contReserved = sp.getInt(TAG,0)
        lifecycle.addObserver(MyObserver())
        mainViewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        plusOneBtn.setOnClickListener{
            mainViewModel.plusOne()
            refreshCounter()
        }
        clear_btn.setOnClickListener{
            mainViewModel.clear()
            refreshCounter()
        }
        mainViewModel.getuser("l").observe(this){
            user->
            println(user.toString())
        }
    }
    private fun refreshCounter(){
        infotext.text = mainViewModel.counter.toString()
    }

    override fun onPause() {
        super.onPause()
        sp.edit {
            putInt(TAG,mainViewModel.counter.value?:0)
        }
    }
}