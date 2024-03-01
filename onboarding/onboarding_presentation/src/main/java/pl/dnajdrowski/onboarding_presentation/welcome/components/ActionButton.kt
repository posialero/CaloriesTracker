package pl.dnajdrowski.onboarding_presentation.welcome.components

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import pl.dnajdrowski.core_ui.LocalSpacing

@Composable
fun ActionButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    isEnabled: Boolean = false,
    textStyle: TextStyle = MaterialTheme.typography.bodyMedium
) {
    Button(
        modifier = modifier,
        onClick = onClick,
        enabled = isEnabled,
        shape = Shapes().small
    ) {
        Text(
            text = text,
            style = textStyle,
            color = MaterialTheme.colorScheme.onPrimary,
            modifier = Modifier.padding(LocalSpacing.current.spaceSmall)
        )
    }
}