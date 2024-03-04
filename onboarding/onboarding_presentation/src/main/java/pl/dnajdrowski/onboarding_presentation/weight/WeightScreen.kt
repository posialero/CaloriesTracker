package pl.dnajdrowski.onboarding_presentation.weight

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import pl.dnajdrowski.core.R
import pl.dnajdrowski.core.util.UiEvent
import pl.dnajdrowski.core_ui.LocalSpacing
import pl.dnajdrowski.core_ui.components.AnimatedLottiePreloader
import pl.dnajdrowski.core_ui.components.UnitTextField
import pl.dnajdrowski.onboarding_presentation.components.ActionButton

@Composable
fun WeightScreen(
    onNavigate: (UiEvent.Navigate) -> Unit,
    viewModel: WeightViewModel = hiltViewModel(),
    snackBarHostState: SnackbarHostState
) {
    val spacing = LocalSpacing.current
    val context = LocalContext.current

    LaunchedEffect(key1 = true) {
        viewModel.uiEvent.collect { event ->
            when (event) {
                is UiEvent.Navigate -> onNavigate(event)
                is UiEvent.ShowSnackBar -> {
                    snackBarHostState.showSnackbar(
                        message = event.message.asString(context)
                    )
                }
                else -> {}
            }
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(LocalSpacing.current.spaceMedium),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        AnimatedLottiePreloader(
            modifier = Modifier
                .size(300.dp),
            rawId = R.raw.weight_animation
        )
        Spacer(modifier = Modifier.height(spacing.spaceExtraLarge))
        UnitTextField(
            value = viewModel.weight,
            onValueChanged = viewModel::onWeightEnter,
            unit = stringResource(id = R.string.kg)
        )
        Spacer(modifier = Modifier.height(spacing.spaceExtraLarge))
        ActionButton(
            text = stringResource(id = R.string.next),
            onClick = viewModel::onNextClick,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
    }
}