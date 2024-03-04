package pl.dnajdrowski.onboarding_presentation.activity

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import pl.dnajdrowski.core.domain.model.ActivityLevel
import pl.dnajdrowski.core.domain.model.Gender
import pl.dnajdrowski.core.domain.preferences.Preferences
import pl.dnajdrowski.core.navigation.Route
import pl.dnajdrowski.core.util.UiEvent
import javax.inject.Inject

@HiltViewModel
class ActivityViewModel @Inject constructor(
    private val preferences: Preferences
): ViewModel() {
    var selectedIndex by mutableIntStateOf(
        ActivityLevel.entries.indexOf(ActivityLevel.Low)
    )
        private set

    private val _uiEvent = Channel<UiEvent>()
    val uiEvent = _uiEvent.receiveAsFlow()

    fun onActivityClicked(activity: ActivityLevel) {
        selectedIndex = ActivityLevel.entries.indexOf(activity)
    }

    fun onNextClick() {
        viewModelScope.launch {
            preferences.saveActivityLevel(
                ActivityLevel.entries[selectedIndex]
            )
            _uiEvent.send(UiEvent.Navigate(Route.GOAL))
        }
    }
}