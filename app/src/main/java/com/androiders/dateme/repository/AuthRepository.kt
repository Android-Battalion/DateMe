package com.androiders.dateme.repository

import com.androiders.dateme.util.NetworkResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import javax.inject.Inject
import kotlinx.coroutines.tasks.await

class AuthRepository @Inject constructor(
    private val firebaseAuth: FirebaseAuth
) {

    val currentUser: FirebaseUser?
        get() = firebaseAuth.currentUser

    suspend fun loginWithEmailAndPassword(
        email: String,
        password: String
    ): NetworkResult<FirebaseUser> {
        return try {
            val result = firebaseAuth.signInWithEmailAndPassword(email, password).await()
            NetworkResult.Success(result.user!!)
        } catch (e: Exception) {
            e.printStackTrace()
            NetworkResult.Error(e.message)
        }
    }

    suspend fun signupWithEmailAndPassword(
        email: String,
        password: String
    ): NetworkResult<FirebaseUser> {
        return try {
            val result = firebaseAuth.createUserWithEmailAndPassword(email, password).await()
            return NetworkResult.Success(result.user!!)
        } catch (e: Exception) {
            e.printStackTrace()
            NetworkResult.Error(e.message)
        }
    }

    fun logout() {
        firebaseAuth.signOut()
    }
}
