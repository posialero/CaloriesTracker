package pl.dnajdrowski.tracker_domain.use_case

import kotlinx.coroutines.flow.Flow
import pl.dnajdrowski.tracker_domain.model.TrackableFood
import pl.dnajdrowski.tracker_domain.model.TrackedFood
import pl.dnajdrowski.tracker_domain.repository.TrackerRepository
import java.time.LocalDate

class DeleteTrackedFood(
    private val repository: TrackerRepository
) {
    suspend operator fun invoke(
        trackedFood: TrackedFood
    ) {
        repository.deleteTrackedFood(trackedFood)
    }
}