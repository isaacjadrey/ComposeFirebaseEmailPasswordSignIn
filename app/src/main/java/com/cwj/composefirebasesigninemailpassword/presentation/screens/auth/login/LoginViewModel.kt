package com.cwj.composefirebasesigninemailpassword.presentation.screens.auth.login

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
class LoginViewModel @Inject constructor(private val repo: AuthRepository) : ViewModel() {
    var loginResponse by mutableStateOf<Response<Boolean>>(Response.Success(false))
        private set

    fun signInUserWIthEmailPassword(email: String, password: String) =
        viewModelScope.launch {
            loginResponse = Response.Loading
            loginResponse = repo.signInUserWIthEmailAndPassword(email, password)
        }
}