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
            popEnterTransition = { _, _ -> fadeIn(animationSpec = tween(300)) },
            exitTransition = { _, _ -> fadeOut(animationSpec = tween(300)) }
    ) {

            HomeScreen(navController = navController)
        }

       composable(route = Screen.LockActivity.route,
           popEnterTransition = { _, _ -> fadeIn(animationSpec = tween(300)) },
        exitTransition = { _, _ -> fadeOut(animationSpec = tween(300)) }
       )
       {

            LockActivityScreen(navController = navController)
        }

    }
}

