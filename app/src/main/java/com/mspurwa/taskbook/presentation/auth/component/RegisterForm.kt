package com.mspurwa.taskbook.presentation.auth.component


import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Abc
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Password
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.mspurwa.taskbook.R
import com.mspurwa.taskbook.presentation.auth.viewmodel.AuthViewModel
import com.mspurwa.taskbook.presentation.common.component.AppTextField
import com.mspurwa.taskbook.util.CustomPreviews
import kotlinx.coroutines.launch

/**
 * Owner : Mandeep Singh
 * Package Name: com.mspurwa.taskbook.presentation.auth.component
 * Project Name: TaskBook
 * Created At: Thu, 06 Jun 2024
 **/

@Composable
fun RegisterForm(viewModel: AuthViewModel = hiltViewModel()) {
    val scope = rememberCoroutineScope()
    val focusManager = LocalFocusManager.current
    val scrollState = rememberScrollState()
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(25.dp)
            .verticalScroll(scrollState)
        ,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        //First Name
        AppTextField(
            value = viewModel.firstName,
            onChange = viewModel::updateFirstName,
            placeholder = stringResource(id = R.string.firstname),
            contentDescription = stringResource(id = R.string.firstname),
            leadingIcon = Icons.Filled.Abc,
            imeAction = ImeAction.Next,
            keyBoardAction = KeyboardActions(
                onNext = {
                    scope.launch {
                        focusManager.moveFocus(FocusDirection.Down)
                    }
                }
            )
        )
        //Last Name
        AppTextField(
            value = viewModel.lastName,
            onChange = viewModel::updateLastName,
            placeholder = stringResource(id = R.string.lastname),
            contentDescription = stringResource(id = R.string.lastname),
            leadingIcon = Icons.Filled.Abc,
            imeAction = ImeAction.Next,
            keyBoardAction = KeyboardActions(
                onNext = {
                    scope.launch {
                        focusManager.moveFocus(FocusDirection.Down)
                    }
                }
            )

        )
        //EmailId
        AppTextField(
            value = viewModel.emailId,
            onChange = viewModel::updateEmailId,
            placeholder = stringResource(id = R.string.email_id),
            contentDescription = stringResource(id = R.string.email_id),
            leadingIcon = Icons.Filled.Email,
            imeAction = ImeAction.Next,
            keyBoardAction = KeyboardActions(
                onNext = {
                    scope.launch {
                        focusManager.moveFocus(FocusDirection.Down)
                    }
                }
            )
        )

        //Username
        AppTextField(
            value = viewModel.userName,
            onChange = viewModel::updateUserName,
            placeholder = stringResource(id = R.string.username),
            contentDescription = stringResource(id = R.string.username),
            leadingIcon = Icons.Filled.Abc,
            imeAction = ImeAction.Next,
            keyBoardAction = KeyboardActions(
                onNext = {
                    scope.launch {
                        focusManager.moveFocus(FocusDirection.Down)
                    }
                }
            )
        )

        //Password
        AppTextField(
            value = viewModel.password,
            onChange = viewModel::updatePassword,
            placeholder = stringResource(id = R.string.password),
            contentDescription = stringResource(id = R.string.password),
            leadingIcon = Icons.Filled.Password,
            imeAction = ImeAction.Next,
            keyBoardAction = KeyboardActions(
                onNext = {
                    scope.launch {
                        focusManager.moveFocus(FocusDirection.Down)
                    }
                }
            ),
            isPasswordField = true,
            passwordVisibility = viewModel.isPasswordVisible,
            onChangePasswordVisibility = viewModel::updatePasswordVisibility
        )

        // Confirm Password
        AppTextField(
            value = viewModel.confirmPassword,
            onChange = viewModel::updateConfirmPassword,
            placeholder = stringResource(id = R.string.confirm_password),
            contentDescription = stringResource(id = R.string.confirm_password),
            leadingIcon = Icons.Filled.Password,
            imeAction = ImeAction.Done,
            keyBoardAction = KeyboardActions(
                onDone = {
                    scope.launch {
                        focusManager.clearFocus()
                    }
                }
            ),
            isPasswordField = true,
            passwordVisibility = viewModel.isConfirmPasswordVisible,
            onChangePasswordVisibility = viewModel::updateConfirmPasswordVisibility
        )
        Spacer(modifier = Modifier.height(30.dp))
        Button(onClick = { viewModel.registerUser() }, enabled = viewModel.isDataValidated) {
            Text(text = stringResource(id = R.string.Submit))
        }
    }
}

@Composable
@CustomPreviews
fun PreviewRegisterForm() {
    RegisterForm(
        viewModel = hiltViewModel()
    )
}

