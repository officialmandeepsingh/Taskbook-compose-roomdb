package com.mspurwa.taskbook.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Owner : Mandeep Singh
 * Package Name: com.mspurwa.taskbook.data.local
 * Project Name: TaskBook
 * Created At: Fri, 07 Jun 2024
 **/

@Entity(tableName = "user")
data class UserEntity(
    @PrimaryKey(autoGenerate = true) val userId: Int = 0,
    val firstName: String,
    val lastName: String,
    val emailId: String,
    val userName: String,
    val password: String,

)