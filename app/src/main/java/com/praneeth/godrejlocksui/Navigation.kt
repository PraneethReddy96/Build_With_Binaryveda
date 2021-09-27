package com.praneeth.godrejlocksui

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.runtime.Composable
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable
import com.google.accompanist.navigation.animation.rememberAnimatedNavController




@ExperimentalAnimationApi
@Composable
fun Navigation() {
    val navController = rememberAnimatedNavController()

    AnimatedNavHost(navController, startDestination = Screen.HomeScreen.route) {

        composable(route = Screen.HomeScreen.route,
            enterTransition = { _, _ ->
                slideInHorizontally(initialOffsetX = { it / 2 },
                    animationSpec = tween(500))
            },
            exitTransition = { _, _ ->
                slideOutHorizontally(targetOffsetX = { it / 2 },
                    animationSpec = tween(500)) }
    ) {

            HomeScreen(navController = navController)
        }

       composable(route = Screen.LockActivity.route,
            enterTransition = { _, _ ->
                slideInHorizontally(initialOffsetX = { it / 2 },
                    animationSpec = tween(500))
            },
            exitTransition = { _, _ ->
                slideOutHorizontally(targetOffsetX = { it / 2 },
                    animationSpec = tween(500)) }
       )
       {

            LockActivityScreen(navController = navController)
        }

    }
}

//        composable(route = Screen.HomeScreen.route,
//        ){
//                HomeScreen(navController = navController)
//        }
//
//        composable(route = Screen.LockActivity.route,
//        ){
//            LockActivityScreen(navController = navController)
//        }


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
