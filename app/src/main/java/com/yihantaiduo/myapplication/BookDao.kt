package com.yihantaiduo.myapplication

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface BookDao {
@Insert
fun insertBook(book:Book):Long
@Query("select * from Book")
fun queryBook()
}