package pl.dnajdrowski.caloriestracker

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import pl.dnajdrowski.caloriestracker.navigation.navigate
import pl.dnajdrowski.caloriestracker.ui.theme.CaloriesTrackerTheme
import pl.dnajdrowski.core.navigation.Route
import pl.dnajdrowski.core_ui.components.states.rememberTypewriterState
import pl.dnajdrowski.onboarding_presentation.activity.ActivityScreen
import pl.dnajdrowski.onboarding_presentation.age.AgesScreen
import pl.dnajdrowski.onboarding_presentation.welcome.WelcomeScreen
import pl.dnajdrowski.onboarding_presentation.gender.GenderScreen
import pl.dnajdrowski.onboarding_presentation.goal.GoalScreen
import pl.dnajdrowski.onboarding_presentation.height.HeightScreen
import pl.dnajdrowski.onboarding_presentation.nutrien_goal.NutrientGoalScreen
import pl.dnajdrowski.onboarding_presentation.weight.WeightScreen

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CaloriesTrackerTheme(dynamicColor = false) {
                val navController = rememberNavController()
                val snackBarHostState = remember { SnackbarHostState() }
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    snackbarHost = {
                        SnackbarHost(hostState = snackBarHostState)
                    }
                ) { paddingValues ->
                    NavHost(
                        modifier = Modifier
                            .padding(top = paddingValues.calculateTopPadding())
                            .padding(bottom = paddingValues.calculateBottomPadding()),
                        navController = navController,
                        startDestination = Route.WELCOME
                    ) {
                        composable(Route.WELCOME) {
                            val welcomeTextTypewriterState = rememberTypewriterState(
                                stringResource(id = pl.dnajdrowski.core.R.string.welcome_text)
                            )

                            LaunchedEffect(key1 = welcomeTextTypewriterState) {
                                welcomeTextTypewriterState.animate()
                            }

                            WelcomeScreen(
                                welcomeTextTypewriterState = welcomeTextTypewriterState,
                                onNavigate = navController::navigate
                            )
                        }
                        composable(Route.GENDER) {
                            GenderScreen(onNavigate = navController::navigate)
                        }
                        composable(Route.AGE) {
                            AgesScreen(
                                onNavigate = navController::navigate,
                                snackBarHostState = snackBarHostState
                            )
                        }
                        composable(Route.HEIGHT) {
                            HeightScreen(
                                onNavigate = navController::navigate,
                                snackBarHostState = snackBarHostState
                            )
                        }
                        composable(Route.WEIGHT) {
                            WeightScreen(
                                onNavigate = navController::navigate,
                                snackBarHostState = snackBarHostState
                            )
                        }
                        composable(Route.NUTRIENT_GOAL) {
                            NutrientGoalScreen(
                                onNavigate = navController::navigate,
                                snackBarHostState = snackBarHostState
                            )
                        }
                        composable(Route.ACTIVITY) {
                            ActivityScreen(onNavigate = navController::navigate)
                        }
                        composable(Route.GOAL) {
                            GoalScreen(onNavigate = navController::navigate)
                        }
                        composable(Route.TRACKER_OVERVIEW) {
                        }
                        composable(Route.SEARCH) {
                        }

                    }
                }
            }
        }
    }
}