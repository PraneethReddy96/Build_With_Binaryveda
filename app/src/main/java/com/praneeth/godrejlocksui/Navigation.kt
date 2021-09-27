package com.praneeth.godrejlocksui

import androidx.compose.animation.*
import androidx.compose.animation.core.tween
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.navigation.animation.AnimatedNavHost
//import com.google.accompanist.navigation.animation.composable
import com.google.accompanist.navigation.animation.rememberAnimatedNavController

//
//inline fun Modifier.noRippleClickable(crossinline onClick: () -> Unit): Modifier = composed {
//    clickable(indication = null,
//        interactionSource = remember { MutableInteractionSource() }) {
//        onClick()
//    }
//}


@ExperimentalMaterialApi
@ExperimentalAnimationApi
@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController, startDestination = Screen.HomeScreen.route) {


        composable(route = Screen.HomeScreen.route,
        ){
                HomeScreen(navController = navController)
        }

        composable(route = Screen.LockActivity.route,
        ){
            LockActivityScreen(navController = navController)
        }

    }
}

//
//val navController = rememberAnimatedNavController()
//
//AnimatedNavHost(navController, startDestination = "first") {
//    composable(
//        route = "first",
//        enterTransition = { _, _ -> slideInHorizontally(animationSpec = tween(500)) },
//        exitTransition = { _, _ -> slideOutHorizontally(animationSpec = tween(500)) }
//    ) {
//        FirstScreen()
//    }
//    composable(
//        route = "second",
//        enterTransition = { _, _ -> slideInHorizontally(initialOffsetX = { it / 2 }, animationSpec = tween(500)) },
//        exitTransition = { _, _ -> slideOutHorizontally(targetOffsetX = { it / 2 }, animationSpec = tween(500)) }
//    ) {
//        SecondScreen()
//    }
//}

//enterTransition = { _, _ -> slideInHorizontally(animationSpec = tween(500)) },
//exitTransition = { _, _ -> slideOutHorizontally(animationSpec = tween(500)) })

//composable(route = Screen.LockActivity.route,
//enterTransition = { _, _ ->
//    slideInHorizontally(initialOffsetX = { it / 2 },
//        animationSpec = tween(500))
//},
//exitTransition = { _, _ ->
//    slideOutHorizontally(targetOffsetX = { it / 2 },
//        animationSpec = tween(500))
//}) {
//
//    LockActivityScreen(navController = navController)
//}
