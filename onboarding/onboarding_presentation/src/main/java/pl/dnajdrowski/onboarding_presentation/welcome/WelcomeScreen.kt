package pl.dnajdrowski.onboarding_presentation.welcome

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import pl.dnajdrowski.core.R
import pl.dnajdrowski.core_ui.LocalSpacing
import pl.dnajdrowski.onboarding_presentation.welcome.components.ActionButton

@Composable
fun WelcomeScreen() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val spacing = LocalSpacing.current

        Text(
            text = stringResource(id = R.string.welcome_text),
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.titleLarge
        )
        Spacer(modifier = Modifier
            .height(spacing.spaceMedium)
        )
        ActionButton(
            text = stringResource(id = R.string.next),
            onClick = { },
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
    }
}