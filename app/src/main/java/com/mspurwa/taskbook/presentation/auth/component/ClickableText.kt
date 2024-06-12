package com.mspurwa.taskbook.presentation.auth.component

import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.PreviewLightDark

/**
 * Owner : Mandeep Singh
 * Package Name: com.mspurwa.taskbook.presentation.auth.component
 * Project Name: TaskBook
 * Created At: Wed, 05 Jun 2024
 **/

@Composable
fun ClickableText(
    onClick: () -> Unit,
    labelText: String,
    boldText: String,
    tag: String = "TAG",
    annotation: String = "Annotation"
) {
    val annotatedString = buildAnnotatedString {
        append(labelText)
        pushStringAnnotation(tag = tag, annotation = annotation)
        withStyle(style = SpanStyle(color = colorScheme.primary, fontWeight = FontWeight.Bold)) {
            append(boldText)
        }
        pop()
    }

    ClickableText(text = annotatedString, onClick = { offset ->
        annotatedString.getStringAnnotations(tag = tag, start = offset, end = offset)
            .firstOrNull()?.let { onClick() }

    })

}

@Composable
//@PreviewScreenSizes
@PreviewLightDark
fun PreviewRegisterText() {

}