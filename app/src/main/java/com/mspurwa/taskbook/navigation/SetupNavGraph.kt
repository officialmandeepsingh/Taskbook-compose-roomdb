package com.mspurwa.taskbook.navigation

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.EaseIn
import androidx.compose.animation.core.EaseOut
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.mspurwa.taskbook.presentation.auth.navigation.loginScreen
import com.mspurwa.taskbook.presentation.auth.navigation.registerScreen

/**
 * Owner : Mandeep Singh
 * Package Name: com.mspurwa.taskbook.navigation
 * Project Name: TaskBook
 * Created At: Wed, 05 Jun 2024
 **/


@Composable
fun SetupNavGraph(startDestination: Screen, navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = startDestination.route,
        enterTransition = {
            fadeIn(
                animationSpec = tween(
                    300, easing = LinearEasing
                )
            ) + slideIntoContainer(
                animationSpec = tween(300, easing = EaseIn),
                towards = AnimatedContentTransitionScope.SlideDirection.Start
            )
        },
        exitTransition = {
            fadeOut(
                animationSpec = tween(
                    300, easing = LinearEasing
                )
            ) + slideOutOfContainer(
                animationSpec = tween(300, easing = EaseOut),
                towards = AnimatedContentTransitionScope.SlideDirection.End
            )
        }) {
        loginScreen(onNewUserReq = {navController.navigate(Screen.RegisterScreen.route)})
        registerScreen()
    }

}