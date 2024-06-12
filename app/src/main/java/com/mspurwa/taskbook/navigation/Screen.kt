package com.mspurwa.taskbook.navigation

/**
 * Owner : Mandeep Singh
 * Package Name: com.mspurwa.taskbook.navigation
 * Project Name: TaskBook
 * Created At: Wed, 05 Jun 2024
 **/
sealed class Screen(val route: String){
    object LoginScreen: Screen("login_screen")
    object RegisterScreen: Screen("register_screen")
    object HomeScreen: Screen("home_screen")
    object AddTask: Screen("add_task_screen")
    object ProfileScreen: Screen("profile_screen")
}

