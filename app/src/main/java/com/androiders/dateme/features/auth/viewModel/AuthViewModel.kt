package com.androiders.dateme.features.auth.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.androiders.dateme.repository.AuthRepository
import com.androiders.dateme.util.NetworkResult
import com.google.firebase.auth.FirebaseUser
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

@HiltViewModel
class AuthViewModel @Inject constructor(private val authRepository: AuthRepository) : ViewModel() {

    private val _loginFlow = MutableStateFlow<NetworkResult<FirebaseUser>?>(null)
    val loginFlow: StateFlow<NetworkResult<FirebaseUser>?> = _loginFlow

    private val _signupFlow = MutableStateFlow<NetworkResult<FirebaseUser>?>(null)
    val signupFlow: StateFlow<NetworkResult<FirebaseUser>?> = _signupFlow

    val currentUser: FirebaseUser?
        get() = authRepository.currentUser

    init {
        if (authRepository.currentUser != null) {
            _loginFlow.value = NetworkResult.Success(authRepository.currentUser!!)
        }
    }

    fun loginWithEmailAndPassword(email: String, password: String) = viewModelScope.launch {
        _loginFlow.value = NetworkResult.Loading()
        val result = authRepository.loginWithEmailAndPassword(email, password)
        _loginFlow.value = result
    }

    fun signupWithEmailAndPassword(email: String, password: String) = viewModelScope.launch {
        _signupFlow.value = NetworkResult.Loading()
        val result = authRepository.signupWithEmailAndPassword(email, password)
        _signupFlow.value = result
    }

    fun logout() {
        authRepository.logout()
        _loginFlow.value = null
        _signupFlow.value = null
    }
}
