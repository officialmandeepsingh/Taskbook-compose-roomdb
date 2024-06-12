package com.mspurwa.taskbook.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

/**
 * Owner : Mandeep Singh
 * Package Name: com.mspurwa.taskbook.data.local
 * Project Name: TaskBook
 * Created At: Fri, 07 Jun 2024
 **/

@Database(entities = [UserEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun UserDao(): UserDao
}