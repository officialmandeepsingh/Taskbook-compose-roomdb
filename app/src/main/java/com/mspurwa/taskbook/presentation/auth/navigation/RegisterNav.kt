package com.mspurwa.taskbook.presentation.auth.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.mspurwa.taskbook.navigation.Screen
import com.mspurwa.taskbook.presentation.auth.screen.LoginScreen
import com.mspurwa.taskbook.presentation.auth.screen.RegisterScreen

/**
 * Owner : Mandeep Singh
 * Package Name: com.mspurwa.taskbook.presentation.auth.navigation
 * Project Name: TaskBook
 * Created At: Thu, 06 Jun 2024
 **/

fun NavGraphBuilder.registerScreen(){
    composable(route = Screen.RegisterScreen.route){
        RegisterScreen(onUserLoginReq = {}, onNavigateToNext = {})
    }
}