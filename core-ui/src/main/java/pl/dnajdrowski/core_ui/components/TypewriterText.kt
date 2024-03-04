package pl.dnajdrowski.core_ui.components

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import pl.dnajdrowski.core.R
import pl.dnajdrowski.core_ui.components.states.TypewriterState

@Composable
fun TypewriterText(
    typewriterState: TypewriterState,
    textAlign: TextAlign = TextAlign.Center,
    textStyle: TextStyle = MaterialTheme.typography.titleLarge
) {
    val text by typewriterState.currentText

    Text(
        text = text,
        textAlign = textAlign,
        style = textStyle
    )
}

@Composable
@Preview
fun TypewriterTextPreview() {
    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        TypewriterText(
            typewriterState = TypewriterState(stringResource(id = R.string.welcome_text))
        )
    }
}