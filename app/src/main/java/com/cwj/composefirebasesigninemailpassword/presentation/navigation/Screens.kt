package com.cwj.composefirebasesigninemailpassword.presentation.navigation

import com.cwj.composefirebasesigninemailpassword.util.Constants.FORGOT_PASSWORD_SCREEN
import com.cwj.composefirebasesigninemailpassword.util.Constants.HOME_SCREEN
import com.cwj.composefirebasesigninemailpassword.util.Constants.LOGIN_SCREEN
import com.cwj.composefirebasesigninemailpassword.util.Constants.SIGNUP_SCREEN

sealed class Screens(val route: String) {
    object LoginScreen: Screens(LOGIN_SCREEN)
    object ForgotPassword: Screens(FORGOT_PASSWORD_SCREEN)
    object SignupScreen: Screens(SIGNUP_SCREEN)
    object Home: Screens(HOME_SCREEN)
}
