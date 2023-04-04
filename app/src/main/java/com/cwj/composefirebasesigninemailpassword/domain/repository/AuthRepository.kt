package com.cwj.composefirebasesigninemailpassword.domain.repository

import com.cwj.composefirebasesigninemailpassword.domain.model.Response
import com.google.firebase.auth.FirebaseUser

interface AuthRepository {
    val currentUser: FirebaseUser?

    suspend fun signUpUserWithEmailAndPassword(email: String, password: String): Response<Boolean>

    suspend fun signInUserWIthEmailAndPassword(email: String, password: String): Response<Boolean>

    suspend fun sendPasswordRestEmail(email: String): Response<Boolean>
}