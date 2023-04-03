package com.cwj.composefirebasesigninemailpassword.presentation.navigation

import androidx.compose.animation.*
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.cwj.composefirebasesigninemailpassword.presentation.navigation.Screens.*
import com.cwj.composefirebasesigninemailpassword.presentation.screens.auth.forgot_password.ForgotPasswordScreen
import com.cwj.composefirebasesigninemailpassword.presentation.screens.auth.login.LoginScreen
import com.cwj.composefirebasesigninemailpassword.presentation.screens.auth.signup.SignUpScreen
import com.cwj.composefirebasesigninemailpassword.presentation.screens.home.HomeScreen
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun NavGraph(navController: NavHostController) {
    AnimatedNavHost(
        navController = navController,
        startDestination = Login.route,
//        enterTransition = {
//            slideInHorizontally(initialOffsetX = { 1000 })
////            fadeIn(animationSpec = tween(2000))
//        },
//        exitTransition = { slideOutHorizontally(targetOffsetX = { -1000 }) }
    ) {
        composable(
            Login.route,
            exitTransition = {
                slideOutHorizontally(
                    targetOffsetX = { -1000 },
                    animationSpec = tween(1000, easing = FastOutSlowInEasing)
                ) + fadeOut(animationSpec = tween(1500))
            },
            popEnterTransition = {
                slideInHorizontally(
                    initialOffsetX = { -1000 },
                    animationSpec = tween(1000, easing = FastOutSlowInEasing)
                ) + fadeIn(animationSpec = tween(1500))
            }
        ) {
            LoginScreen(
                navigateToForgotPassword = { navController.navigate(ForgotPassword.route) },
                navigateToSignUp = { navController.navigate(Signup.route) }
            )
        }
        composable(ForgotPassword.route,
            enterTransition = {
                slideInHorizontally(
                    initialOffsetX = { 1000 },
                    animationSpec = tween(1000, easing = FastOutSlowInEasing)
                ) + fadeIn(animationSpec = tween(1500))
            },
            popExitTransition = {
                slideOutHorizontally(
                    targetOffsetX = { 1000 },
                    animationSpec = tween(1000, easing = FastOutSlowInEasing)
                ) + fadeOut(animationSpec = tween(1500))
            }
        ) {
            ForgotPasswordScreen()
        }
        composable(Signup.route,
            enterTransition = {
                slideInHorizontally(
                    initialOffsetX = { 1000 },
                    animationSpec = tween(1000, easing = FastOutSlowInEasing)
                ) + fadeIn(animationSpec = tween(1500))
            },
            popExitTransition = {
                slideOutHorizontally(
                    targetOffsetX = { 1000 },
                    animationSpec = tween(1000, easing = FastOutSlowInEasing)
                ) + fadeOut(animationSpec = tween(1500))
            }
        ) {
            SignUpScreen(
                navigateToLogin = { navController.popBackStack() },
                navigateToHome = { navController.navigate(Home.route){
                    popUpTo(navController.graph.id) {
                        inclusive = true
                    }}
                }
            )
        }
        composable(Home.route,
            enterTransition = {
                slideInHorizontally(
                    initialOffsetX = { 1000 },
                    animationSpec = tween(1000, easing = FastOutSlowInEasing)
                ) + fadeIn(animationSpec = tween(1500))
            },
            popExitTransition = {
                slideOutHorizontally(
                    targetOffsetX = { 1000 },
                    animationSpec = tween(1000, easing = FastOutSlowInEasing)
                ) + fadeOut(animationSpec = tween(1500))
            }
        ) {
            HomeScreen()
        }
    }
}