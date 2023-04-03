package com.cwj.composefirebasesigninemailpassword.presentation.navigation

import com.cwj.composefirebasesigninemailpassword.util.Constants.FORGOT_PASSWORD_SCREEN
import com.cwj.composefirebasesigninemailpassword.util.Constants.HOME_SCREEN
import com.cwj.composefirebasesigninemailpassword.util.Constants.LOGIN_SCREEN
import com.cwj.composefirebasesigninemailpassword.util.Constants.SIGNUP_SCREEN

sealed class Screens(val route: String) {
    object Login: Screens(LOGIN_SCREEN)
    object ForgotPassword: Screens(FORGOT_PASSWORD_SCREEN)
    object Signup: Screens(SIGNUP_SCREEN)
    object Home: Screens(HOME_SCREEN)
}
