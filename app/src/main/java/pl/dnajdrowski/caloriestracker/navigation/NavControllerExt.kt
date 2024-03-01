package pl.dnajdrowski.caloriestracker.navigation

import androidx.navigation.NavController
import pl.dnajdrowski.core.util.UiEvent

fun NavController.navigate(event: UiEvent.Navigate) {
    this.navigate(event.route)
}