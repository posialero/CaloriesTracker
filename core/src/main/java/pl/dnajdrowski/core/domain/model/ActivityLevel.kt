package pl.dnajdrowski.core.domain.model

sealed class ActivityLevel(val name: String) {
    data object Low: ActivityLevel("low")
    data object Medium: ActivityLevel("medium")
    data object High: ActivityLevel("high")

    companion object {
        fun fromString(name: String): ActivityLevel {
            return when (name) {
                "lose_weight" -> Low
                "keep_weight" -> Medium
                "gain_weight" -> High
                else -> Medium
            }
        }
    }
}