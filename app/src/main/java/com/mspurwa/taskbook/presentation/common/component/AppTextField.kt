package com.mspurwa.taskbook.presentation.common.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp

/**
 * Owner : Mandeep Singh
 * Package Name: com.mspurwa.taskbook.presentation.common.component
 * Project Name: TaskBook
 * Created At: Thu, 06 Jun 2024
 **/

@Composable
fun AppTextField(
    value: String,
    onChange: (text: String) -> Unit,
    imeAction: ImeAction = ImeAction.None,
    placeholder: String,
    contentDescription: String,
    passwordVisibility: Boolean = false,
    isPasswordField: Boolean = false,
    leadingIcon: ImageVector,
    trailingIcon: ImageVector? = null,
    keyBoardAction: KeyboardActions,
    onChangePasswordVisibility: () -> Unit? = {},

    ) {
    Column {
        TextField(
            visualTransformation = when (isPasswordField) {
                true -> when (passwordVisibility) {
                    true -> VisualTransformation.None
                    false -> PasswordVisualTransformation()
                }

                false -> VisualTransformation.None
            },

            value = value,
            onValueChange = onChange,
            modifier = Modifier.fillMaxWidth(),
            leadingIcon = { Icon(leadingIcon, contentDescription = contentDescription) },
            trailingIcon = {
                if (isPasswordField) {
                    Icon(
                        when (passwordVisibility) {
                            true -> Icons.Filled.Visibility
                            false -> Icons.Filled.VisibilityOff
                        },
                        contentDescription = "Password Icon",
                        modifier = Modifier.clickable {
                            onChangePasswordVisibility()
                        })
                } else {
                    trailingIcon?.let { it1 -> Icon(it1, contentDescription = contentDescription) }
                }
            },
            placeholder = {
                Text(
                    text = placeholder
                )
            },
            colors = TextFieldDefaults.colors(
                focusedContainerColor = MaterialTheme.colorScheme.primaryContainer,
                unfocusedContainerColor = MaterialTheme.colorScheme.secondaryContainer,
                focusedIndicatorColor = MaterialTheme.colorScheme.tertiary,
                disabledIndicatorColor = Color.Unspecified,
                unfocusedIndicatorColor = Color.Unspecified,
                focusedPlaceholderColor = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.38f),
                unfocusedPlaceholderColor = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.38f)
            ),
            keyboardOptions = KeyboardOptions(
                imeAction = imeAction
            ),
            keyboardActions =keyBoardAction,
            shape = RoundedCornerShape(10),
            maxLines = 1,
            singleLine = true
        )
        Spacer(modifier = Modifier.height(20.dp))
    }
}