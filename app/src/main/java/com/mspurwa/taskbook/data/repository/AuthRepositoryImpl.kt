package com.mspurwa.taskbook.data.repository

import com.mspurwa.taskbook.data.local.UserDao
import com.mspurwa.taskbook.data.local.UserEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import javax.inject.Inject

/**
 * Owner : Mandeep Singh
 * Package Name: com.mspurwa.taskbook.data.repository
 * Project Name: TaskBook
 * Created At: Fri, 07 Jun 2024
 **/
class AuthRepositoryImpl @Inject constructor(private val userDao: UserDao) : AuthRepository {
    override suspend fun checkUserNameAvailability(username: String) {
        /*withContext(Dispatchers.IO) {
            userDao.checkAvailableUsername(username)
        }*/
    }

    override suspend fun loginUser(username: String, password: String): UserEntity? {
        return withContext(Dispatchers.IO) {
                userDao.userLogin(username = username, password = password)
        }
    }

    override suspend fun registerUser(
        firstname: String,
        lastname: String,
        emailId: String,
        username: String,
        password: String
    ) {
        withContext(Dispatchers.IO) {
            userDao.insertUser(
                UserEntity(
                    firstName = firstname,
                    lastName = lastname,
                    emailId = emailId,
                    userName = username,
                    password = password
                )
            )
        }
    }

    override suspend fun getAllUsers(): Flow<List<UserEntity>> {
       return withContext(Dispatchers.IO){
            userDao.getAllUsers()
        }
    }
}