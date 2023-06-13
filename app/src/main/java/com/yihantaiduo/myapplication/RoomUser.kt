package com.yihantaiduo.myapplication

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * 定义数据库实体类
 */
@Entity
data class RoomUser(var firstName:String,var lastName:String,var age:Int){
    @PrimaryKey(autoGenerate = true)
    var id:Long =0
}
