package pl.dnajdrowski.tracker_domain.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import pl.dnajdrowski.core.domain.preferences.Preferences
import pl.dnajdrowski.tracker_domain.repository.TrackerRepository
import pl.dnajdrowski.tracker_domain.use_case.CalculateMealNutrients
import pl.dnajdrowski.tracker_domain.use_case.DeleteTrackedFood
import pl.dnajdrowski.tracker_domain.use_case.GetFoodsForDate
import pl.dnajdrowski.tracker_domain.use_case.SearchFood
import pl.dnajdrowski.tracker_domain.use_case.TrackFood
import pl.dnajdrowski.tracker_domain.use_case.TrackerUseCases

@Module
@InstallIn(ViewModelComponent::class)
object TrackerDomainModule {
    @ViewModelScoped
    @Provides
    fun providesTrackerUseCases(
        repository: TrackerRepository,
        preferences: Preferences
    ): TrackerUseCases {
        return TrackerUseCases(
            trackFood = TrackFood(repository),
            searchFood = SearchFood(repository),
            getFoodsForDate = GetFoodsForDate(repository),
            deleteTrackedFood = DeleteTrackedFood(repository),
            calculateMealNutrients = CalculateMealNutrients(preferences)
        )
    }
}