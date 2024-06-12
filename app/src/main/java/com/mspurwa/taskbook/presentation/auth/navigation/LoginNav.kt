package com.mspurwa.taskbook.presentation.auth.navigation

import androidx.navigation.NavGraph
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.mspurwa.taskbook.navigation.Screen
import com.mspurwa.taskbook.presentation.auth.screen.LoginScreen

/**
 * Owner : Mandeep Singh
 * Package Name: com.mspurwa.taskbook.presentation.auth.navigation
 * Project Name: TaskBook
 * Created At: Wed, 05 Jun 2024
 **/

fun NavGraphBuilder.loginScreen(onNewUserReq: () -> Unit){
    composable(route = Screen.LoginScreen.route){
        LoginScreen(onNewUserReq = onNewUserReq, onNavigateToNext = {})
    }
}