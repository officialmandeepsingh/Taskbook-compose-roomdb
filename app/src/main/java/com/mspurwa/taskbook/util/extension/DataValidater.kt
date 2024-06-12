package com.mspurwa.taskbook.util.extension

import android.util.Patterns

/**
 * Owner : Mandeep Singh
 * Package Name: com.mspurwa.taskbook.util.extension
 * Project Name: TaskBook
 * Created At: Fri, 07 Jun 2024
 **/


infix fun String.isValid(length: Int): Boolean{
    return this.isNotEmpty() && this.length >= length
}

fun String.isEmailValid(): Boolean{
    return this.isNotEmpty() && Patterns.EMAIL_ADDRESS.matcher(this).matches()
}