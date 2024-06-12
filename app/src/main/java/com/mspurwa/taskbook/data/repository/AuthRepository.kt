package com.mspurwa.taskbook.data.repository

import com.mspurwa.taskbook.data.local.UserEntity
import kotlinx.coroutines.flow.Flow

/**
 * Owner : Mandeep Singh
 * Package Name: com.mspurwa.taskbook.data.repository
 * Project Name: TaskBook
 * Created At: Fri, 07 Jun 2024
 **/
interface AuthRepository {
    suspend fun checkUserNameAvailability(username: String)
    suspend fun loginUser(username: String, password:String): UserEntity?
    suspend fun registerUser(firstname: String, lastname: String, emailId: String, username: String, password: String)
    suspend fun getAllUsers(): Flow<List<UserEntity>>
}