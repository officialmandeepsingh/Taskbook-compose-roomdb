package com.mspurwa.taskbook.presentation.auth.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Abc
import androidx.compose.material.icons.filled.Password
import androidx.compose.material3.Button
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.capitalize
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.mspurwa.taskbook.R
import com.mspurwa.taskbook.presentation.auth.viewmodel.AuthViewModel
import com.mspurwa.taskbook.presentation.common.component.AppTextField
import com.mspurwa.taskbook.util.CustomPreviews
import kotlinx.coroutines.launch
import java.util.Locale

/**
 * Owner : Mandeep Singh
 * Package Name: com.mspurwa.taskbook.presentation.auth.component
 * Project Name: TaskBook
 * Created At: Wed, 05 Jun 2024
 **/

@Composable
fun LoginForm(snackbarHostState: SnackbarHostState, viewModel: AuthViewModel = hiltViewModel()) {
    val scope = rememberCoroutineScope()
    val focusManager = LocalFocusManager.current
    val context = LocalContext.current
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(25.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

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
            imeAction = ImeAction.Done,
            keyBoardAction = KeyboardActions(
                onDone = {
                    scope.launch {
                        focusManager.clearFocus()
                    }
                }
            ),
            isPasswordField = true,
            passwordVisibility = viewModel.isPasswordVisible,
            onChangePasswordVisibility = viewModel::updatePasswordVisibility
        )
        Spacer(modifier = Modifier.height(30.dp))
        Button(onClick = {
            viewModel.userLogin(onSuccess = { user ->
                scope.launch {
                    snackbarHostState.showSnackbar(
                        message = context.getString(R.string.welcome,
                            user.firstName.replaceFirstChar {
                                if (it.isLowerCase()) it.titlecase(
                                    Locale.ROOT
                                ) else it.toString()
                            })
                    )
                }
            }, onError = { error ->
                scope.launch {
                    snackbarHostState.showSnackbar(error)
                }
            })

        }, enabled = viewModel.isDataValidated) {
            Text(text = stringResource(id = R.string.Submit))
        }
    }
}

@Composable
@CustomPreviews
fun PreviewLoginForm() {
//    LoginForm()
}