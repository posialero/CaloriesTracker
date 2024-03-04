package pl.dnajdrowski.onboarding_presentation.goal

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import pl.dnajdrowski.core.R
import pl.dnajdrowski.core.domain.model.ActivityLevel
import pl.dnajdrowski.core.domain.model.Gender
import pl.dnajdrowski.core.domain.model.GoalType
import pl.dnajdrowski.core.navigation.Route
import pl.dnajdrowski.core.util.UiEvent
import pl.dnajdrowski.core_ui.LocalSpacing
import pl.dnajdrowski.core_ui.components.AnimatedLottiePreloader
import pl.dnajdrowski.onboarding_presentation.components.ActionButton
import pl.dnajdrowski.onboarding_presentation.components.SingleChoiceSegmentedButtons

@Composable
fun GoalScreen (
    onNavigate: (UiEvent.Navigate) -> Unit,
    viewModel: GoalViewModel = hiltViewModel()
) {
    val spacing = LocalSpacing.current

    LaunchedEffect(key1 = true) {
        viewModel.uiEvent.collect { event ->
            when(event) {
                is UiEvent.Navigate -> onNavigate(event)
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
            rawId = R.raw.activity_animation
        )
        Spacer(modifier = Modifier.height(spacing.spaceExtraLarge))
        SingleChoiceSegmentedButtons(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = spacing.spaceSmall),
            items = GoalType.entries.map { it.name },
            selectedIndex = viewModel.selectedIndex,
            onClick = {
                viewModel.onGoalTypeClicked(GoalType.valueOf(it))
            }
        )
        Spacer(modifier = Modifier.height(spacing.spaceExtraLarge))
        ActionButton(
            text = stringResource(id = R.string.next),
            onClick = {
                onNavigate(UiEvent.Navigate(Route.NUTRIENT_GOAL))
            },
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
    }

}