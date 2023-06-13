package com.yihantaiduo.myapplication;

import androidx.room.*

@Dao
interface UserDao {
    @Insert
    fun insertRoomUser(user: RoomUser): Long
    @Update
    fun updateRoomUser(newuser:RoomUser)
    @Query("select * from RoomUser where age > :age")
    fun loadUserOlderthan(age:Int):List<User>
    @Delete
    fun deleteUser(user:RoomUser)
}
