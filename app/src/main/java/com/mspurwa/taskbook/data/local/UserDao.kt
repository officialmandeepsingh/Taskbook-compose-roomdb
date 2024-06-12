package com.mspurwa.taskbook.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

/**
 * Owner : Mandeep Singh
 * Package Name: com.mspurwa.taskbook.data.local
 * Project Name: TaskBook
 * Created At: Fri, 07 Jun 2024
 **/

@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUser(userEntity: UserEntity)

    @Delete
    suspend fun deleteUser(userEntity: UserEntity)

    @Update
    suspend fun updateUser(userEntity: UserEntity)

    @Query("select * from user where userName = :username")
    fun checkAvailableUsername(username: String): Boolean

    @Query("select * from user where userName = :username and password= :password")
    fun userLogin(username: String, password: String): UserEntity?

    @Query("select * from user")
    fun getAllUsers(): Flow<List<UserEntity>>

}