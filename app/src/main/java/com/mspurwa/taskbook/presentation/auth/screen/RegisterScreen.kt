package com.mspurwa.taskbook.presentation.auth.screen

import android.graphics.Color
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.mspurwa.taskbook.R
import com.mspurwa.taskbook.presentation.auth.component.ClickableText
import com.mspurwa.taskbook.presentation.auth.component.RegisterForm
import com.mspurwa.taskbook.presentation.auth.viewmodel.AuthType
import com.mspurwa.taskbook.presentation.auth.viewmodel.AuthViewModel

/**
 * Owner : Mandeep Singh
 * Package Name: com.mspurwa.taskbook.presentation.auth.screen
 * Project Name: TaskBook
 * Created At: Wed, 05 Jun 2024
 **/

@Composable
fun RegisterScreen(
    onUserLoginReq: () -> Unit,
    onNavigateToNext: () -> Unit,
    viewModel: AuthViewModel = hiltViewModel()
) {

    LaunchedEffect(Unit) {
        viewModel.updateAuthType(AuthType.REGISTER)
    }

    Scaffold {
        Box(
            modifier = Modifier
                .padding(it)
                .fillMaxSize()
                .padding(25.dp),
        ) {
            RegisterForm()
            Column(modifier = Modifier.align(Alignment.BottomCenter)) {
                ClickableText(
                    labelText = stringResource(id = R.string.have_an_account),
                    boldText = stringResource(id = R.string.login),
                    tag = stringResource(id = R.string.login),
                    annotation = stringResource(id = R.string.login),
                    onClick = onUserLoginReq
                )
            }
        }
    }
}


@Preview(showBackground = true, locale = "pa")
@Preview(showBackground = true, locale = "hi")
@Composable
fun PreviewRegisterScreen() {
    RegisterScreen(onUserLoginReq = { /*TODO*/ }, onNavigateToNext = {})
}