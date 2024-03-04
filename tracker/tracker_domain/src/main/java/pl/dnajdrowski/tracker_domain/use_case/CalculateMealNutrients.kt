package pl.dnajdrowski.tracker_domain.use_case

import pl.dnajdrowski.core.domain.model.ActivityLevel
import pl.dnajdrowski.core.domain.model.Gender
import pl.dnajdrowski.core.domain.model.GoalType
import pl.dnajdrowski.core.domain.model.UserInfo
import pl.dnajdrowski.core.domain.preferences.Preferences
import pl.dnajdrowski.tracker_domain.model.MealType
import pl.dnajdrowski.tracker_domain.model.TrackedFood
import kotlin.math.roundToInt

class CalculateMealNutrients(
    private val preferences: Preferences
) {

    operator fun invoke(
        trackedFoods: List<TrackedFood>
    ): Result {
        val allNutrients = trackedFoods
            .groupBy { it.mealType }
            .mapValues { entry ->
                val type = entry.key
                val foods = entry.value
                MealNutrients(
                    carbs = foods.sumOf { it.carbs },
                    protein = foods.sumOf { it.protein },
                    fat = foods.sumOf { it.fat },
                    calories = foods.sumOf { it.calories },
                    mealType = type
                )
            }
        val totalCarbs = allNutrients.values.sumOf { it.carbs }
        val totalProtein = allNutrients.values.sumOf { it.protein }
        val totalFat = allNutrients.values.sumOf { it.fat }
        val totalCalories = allNutrients.values.sumOf { it.calories }

        val userInfo = preferences.loadUserInfo()
        val caloriesGoal = dailyCaloriesRequirement(userInfo)
        val carbsGoal = (caloriesGoal * userInfo.carbRatio / 4f).roundToInt()
        val proteinGoal = (caloriesGoal * userInfo.proteinRatio / 4f).roundToInt()
        val fatGoal = (caloriesGoal * userInfo.fatRatio / 9f).roundToInt()

        return Result(
            carbsGoal = carbsGoal,
            proteinGoal = proteinGoal,
            fatGoal = fatGoal,
            caloriesGoal = caloriesGoal,
            totalCarbs = totalCarbs,
            totalProtein = totalProtein,
            totalFat = totalFat,
            totalCalories = totalCalories,
            mealNutrients = allNutrients
        )

    }

    private fun dailyCaloriesRequirement(userInfo: UserInfo): Int {
        val activityFactor = when (userInfo.activityLevel) {
            ActivityLevel.Low -> 1.2f
            ActivityLevel.Medium -> 1.3f
            ActivityLevel.High -> 1.4f
        }
        val caloriesExtra = when (userInfo.goalType) {
            GoalType.LostWeight -> -500
            GoalType.KeepWeight -> 0
            GoalType.GainWeight -> 500
        }
        return (bmr(userInfo) * activityFactor + caloriesExtra).roundToInt()
    }

    private fun bmr(userInfo: UserInfo): Int {
        return when (userInfo.gender) {
            Gender.MALE ->  {
                (66.47f + 13.75f * userInfo.weight + 5f * userInfo.height - 6.75 * userInfo.age).roundToInt()
            }
            Gender.FEMALE -> {
                (665.09f + 9.56f * userInfo.weight + 1.84f * userInfo.height - 4.67 * userInfo.age).roundToInt()
            }
        }
    }

    data class MealNutrients(
        val carbs: Int,
        val protein: Int,
        val fat: Int,
        val calories: Int,
        val mealType: MealType
    )

    data class Result(
        val carbsGoal: Int,
        val proteinGoal: Int,
        val fatGoal: Int,
        val caloriesGoal: Int,
        val totalCarbs: Int,
        val totalProtein: Int,
        val totalFat: Int,
        val totalCalories: Int,
        val mealNutrients: Map<MealType, MealNutrients>
    )
}