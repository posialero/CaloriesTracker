package pl.dnajdrowski.core.util

sealed class UiEvent {
    data class Navigate(val route: String): UiEvent()
    data object NavigateUp: UiEvent()
}