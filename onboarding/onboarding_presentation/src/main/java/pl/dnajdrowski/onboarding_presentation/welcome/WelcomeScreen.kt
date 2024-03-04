package pl.dnajdrowski.onboarding_presentation.welcome

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewScreenSizes
import androidx.compose.ui.unit.dp
import pl.dnajdrowski.core.navigation.Route
import pl.dnajdrowski.core.util.UiEvent
import pl.dnajdrowski.core_ui.LocalSpacing
import pl.dnajdrowski.core_ui.components.AnimatedLottiePreloader
import pl.dnajdrowski.core_ui.components.TypewriterText
import pl.dnajdrowski.core_ui.components.states.TypewriterState
import pl.dnajdrowski.core.R
import pl.dnajdrowski.core_ui.components.states.rememberTypewriterState
import pl.dnajdrowski.onboarding_presentation.components.ActionButton

@Composable
fun WelcomeScreen(
    welcomeTextTypewriterState: TypewriterState,
    onNavigate: (UiEvent.Navigate) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(LocalSpacing.current.spaceMedium),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val spacing = LocalSpacing.current

        AnimatedLottiePreloader(
            modifier = Modifier.size(300.dp),
            rawId = R.raw.welcome_animation
        )
        Spacer(modifier = Modifier.height(spacing.spaceExtraLarge))
        TypewriterText(
            typewriterState = welcomeTextTypewriterState
        )
        Spacer(modifier = Modifier.height(spacing.spaceExtraLarge))
        ActionButton(
            text = stringResource(id = R.string.next),
            onClick = {
                onNavigate(UiEvent.Navigate(Route.GENDER))
            },
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
    }
}

@Composable
@PreviewScreenSizes
@Preview
private fun WelcomeScreenPreview() {
    WelcomeScreen(
        welcomeTextTypewriterState = rememberTypewriterState(textToDisplay = "Test"),
        onNavigate = { }
    )
}
