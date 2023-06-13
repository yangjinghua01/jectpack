package com.yihantaiduo.myapplication

import android.content.Context
import androidx.room.*
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import androidx.sqlite.db.SupportSQLiteOpenHelper

@Database(version = 2, entities = [RoomUser::class, Book::class])
abstract class AppDatabase : RoomDatabase() {
    //    抽线dao层
    abstract fun UserDao(): UserDao
    abstract fun BookDao(): BookDao

    companion object {
        //        升级的逻辑
        val MIGRATION_1_2 = object : Migration(1, 2) {
            override fun migrate(database: SupportSQLiteDatabase) {
                database.execSQL("create table Book (id integer primary key autoincrement not null,name text not null,pages integer not null)")
            }
        }
        val MiGRATION_2_3 = object : Migration(2,3){
            override fun migrate(database: SupportSQLiteDatabase) {
                database.execSQL("alter table Book add column author text not null default 'unknown'")
            }

        }


        private var instance: AppDatabase? = null

        @Synchronized
        fun getDataBases(context: Context): AppDatabase {
            instance?.let {
                return it
            }
            return Room.databaseBuilder(context, AppDatabase::class.java, "app_databases")
                .addMigrations(
                    MIGRATION_1_2, MiGRATION_2_3
                ).build().apply {
                instance = this
            }
        }
    }
}