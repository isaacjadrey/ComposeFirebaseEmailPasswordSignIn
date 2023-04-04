package com.cwj.composefirebasesigninemailpassword.presentation.screens.auth.forgot_password

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cwj.composefirebasesigninemailpassword.domain.model.Response
import com.cwj.composefirebasesigninemailpassword.domain.repository.AuthRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ForgotPasswordViewModel @Inject constructor(private val repo: AuthRepository) : ViewModel() {
    var passwordResetResponse by mutableStateOf<Response<Boolean>>(Response.Success(false))

    fun sendPasswordResetEmail(email: String) =
        viewModelScope.launch {
            passwordResetResponse = Response.Loading
            passwordResetResponse = repo.sendPasswordRestEmail(email)
        }
}