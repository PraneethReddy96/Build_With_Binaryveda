package com.praneeth.godrejlocksui

sealed class Screen(val route: String){

    object HomeScreen :Screen("Home_Screen")
    object LockActivity :Screen("Lock_Screen")

}