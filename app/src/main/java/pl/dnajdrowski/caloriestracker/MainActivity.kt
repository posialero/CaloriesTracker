package pl.dnajdrowski.caloriestracker

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import pl.dnajdrowski.caloriestracker.navigation.navigate
import pl.dnajdrowski.caloriestracker.ui.theme.CaloriesTrackerTheme
import pl.dnajdrowski.core.navigation.Route
import pl.dnajdrowski.onboarding_presentation.welcome.WelcomeScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CaloriesTrackerTheme(dynamicColor = false) {
                val navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = Route.WELCOME
                ) {
                    composable(Route.WELCOME) {
                        WelcomeScreen(
                            onNavigate = navController::navigate
                        )
                    }
                    composable(Route.AGE) {
                    }
                    composable(Route.GENDER) {
                    }
                    composable(Route.HEIGHT) {
                    }
                    composable(Route.WEIGHT) {
                    }
                    composable(Route.NUTRIENT_GOAL) {
                    }
                    composable(Route.ACTIVITY) {
                    }
                    composable(Route.GOAL) {
                    }
                    composable(Route.TRACKER_OVERVIEW) {
                    }
                    composable(Route.HEIGHT) {
                    }
                    composable(Route.WEIGHT) {
                    }
                    composable(Route.SEARCH) {
                    }

                }
            }
        }
    }
}