package com.mspurwa.taskbook.presentation.auth.viewmodel

import android.content.Context
import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mspurwa.taskbook.R
import com.mspurwa.taskbook.data.local.UserEntity
import com.mspurwa.taskbook.data.repository.AuthRepository
import com.mspurwa.taskbook.util.extension.isEmailValid
import com.mspurwa.taskbook.util.extension.isValid
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Owner : Mandeep Singh
 * Package Name: com.mspurwa.taskbook.presentation.auth.viewmodel
 * Project Name: TaskBook
 * Created At: Thu, 06 Jun 2024
 **/

enum class AuthType { LOGIN, REGISTER }

@HiltViewModel
class AuthViewModel @Inject constructor(
    private val authRepository: AuthRepository,
    private val context: Context
) : ViewModel() {
    private val TAG: String = "AuthViewModel"

    private var _firstName: MutableState<String> = mutableStateOf("")
    val firstName: String get() = _firstName.value

    private var _lastName: MutableState<String> = mutableStateOf("")
    val lastName: String get() = _lastName.value

    private var _userName: MutableState<String> = mutableStateOf("")
    val userName: String get() = _userName.value

    private var _emailId: MutableState<String> = mutableStateOf("")
    val emailId: String get() = _emailId.value

    private var _password: MutableState<String> = mutableStateOf("")
    val password: String get() = _password.value

    private var _confirmPassword: MutableState<String> = mutableStateOf("")
    val confirmPassword: String get() = _confirmPassword.value

    private var _isDataValidated: MutableState<Boolean> = mutableStateOf(false)
    val isDataValidated: Boolean get() = _isDataValidated.value

    private var _isPasswordVisible: MutableState<Boolean> = mutableStateOf(false)
    val isPasswordVisible: Boolean get() = _isPasswordVisible.value

    private var _isConfirmPasswordVisible: MutableState<Boolean> = mutableStateOf(false)
    val isConfirmPasswordVisible: Boolean get() = _isConfirmPasswordVisible.value

    private var _authType: MutableState<AuthType> = mutableStateOf(AuthType.LOGIN)
    val authType: AuthType get() = _authType.value

    fun updateFirstName(firstName: String) {
        _firstName.value = firstName
        updateDataValidate()
    }

    fun updateLastName(LastName: String) {
        _lastName.value = LastName
        updateDataValidate()
    }

    fun updateUserName(userName: String) {
        _userName.value = userName
        updateDataValidate()
    }

    fun updateEmailId(emailId: String) {
        _emailId.value = emailId
        updateDataValidate()
    }

    fun updatePassword(password: String) {
        _password.value = password
        updateDataValidate()
    }

    fun updateConfirmPassword(password: String) {
        _confirmPassword.value = password
        updateDataValidate()
    }

    fun updateDataValidate() {
        _isDataValidated.value = when (_authType.value) {
            AuthType.LOGIN -> _userName.value isValid 8 && _password.value isValid 8
            AuthType.REGISTER -> _firstName.value isValid 3 && _lastName.value isValid 3 && _emailId.value.isEmailValid() && _userName.value isValid 8 && _password.value isValid 8 && _confirmPassword.value isValid 8
        }
    }


    fun updatePasswordVisibility() {
        _isPasswordVisible.value = !_isPasswordVisible.value

    }

    fun updateConfirmPasswordVisibility() {
        _isConfirmPasswordVisible.value = !_isConfirmPasswordVisible.value
    }

    fun updateAuthType(userAuthType: AuthType) {
        _authType.value = userAuthType
        updateDataValidate()
    }

    fun registerUser() {
        viewModelScope.launch(Dispatchers.IO) {
            authRepository.registerUser(
                firstname = _firstName.value,
                lastname = _lastName.value,
                emailId = _emailId.value,
                username = _userName.value,
                password = _password.value
            )
        }
    }

    fun userLogin(onSuccess: (UserEntity) -> Unit, onError: (exception: String) -> Unit) {
        var userEntity: UserEntity? = null

        getAllUsers()
        viewModelScope.launch {
            userEntity =
                authRepository.loginUser(username = _userName.value, password = _password.value)

            Log.d(TAG, "userLogin() called: ${userEntity.toString()}")
            if (userEntity == null)
                onError(context.getString(R.string.no_user_found))
            else onSuccess(userEntity!!)

        }
    }

    fun getAllUsers() {
        viewModelScope.launch {
            authRepository.getAllUsers().collectLatest {
                Log.d(TAG, "getAllUsers() called ${it.toString()}")
            }
        }
    }

}