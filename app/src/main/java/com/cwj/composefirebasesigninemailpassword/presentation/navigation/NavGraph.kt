package com.cwj.composefirebasesigninemailpassword.presentation.navigation

import androidx.compose.animation.*
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
        enterTransition = {
            slideInHorizontally(initialOffsetX = { 1000 })
//            fadeIn(animationSpec = tween(2000))
        },
        exitTransition = { slideOutHorizontally(targetOffsetX = { -1000 }) }
    ) {
        composable(Login.route) {
            LoginScreen(
                navigateToForgotPassword = { navController.navigate(ForgotPassword.route) },
                navigateToSignUp = { navController.navigate(Signup.route) }
            )
        }
        composable(ForgotPassword.route) {
            ForgotPasswordScreen()
        }
        composable(Signup.route) {
            SignUpScreen(navigateToLogin = { navController.popBackStack() })
        }
        composable(Home.route) {
            HomeScreen()
        }
    }
}