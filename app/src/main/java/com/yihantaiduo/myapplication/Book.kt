package com.yihantaiduo.myapplication

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Book(var name: String, var Pages: Int,var anthor:String) {
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0
}
