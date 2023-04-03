package com.cwj.composefirebasesigninemailpassword.di

import com.cwj.composefirebasesigninemailpassword.data.AuthRepositoryImpl
import com.cwj.composefirebasesigninemailpassword.domain.repository.AuthRepository
import com.google.firebase.auth.FirebaseAuth
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    fun provideAuthRepository(): AuthRepository =
        AuthRepositoryImpl(auth = FirebaseAuth.getInstance())
}