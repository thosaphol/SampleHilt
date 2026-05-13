package com.example.samplehilt.ui.login

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class LoginViewModel : ViewModel() {

    private val _email = MutableStateFlow<String>("")
    val email: StateFlow<String> = _email

    private val _password = MutableStateFlow<String>("")
    val password: StateFlow<String> = _password

    fun onUsernameChange(value: String) {
        _email.value = value
    }

    fun onPasswordChange(value: String) {
        _password.value = value
    }

    fun login(){
        println("Email ${email.value}")
        println("Email ${password.value}")
    }

    fun SampleChange(){
        GlobalScope.launch {
            repeat(5) { it ->
                delay(1000)
                _email.value = "Change Email ${it}"
                delay(1000)
                _password.value = "Change Password ${it}"


            }
        }
    }
}