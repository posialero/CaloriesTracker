package pl.dnajdrowski.tracker_domain.use_case

import kotlinx.coroutines.flow.Flow
import pl.dnajdrowski.tracker_domain.model.TrackableFood
import pl.dnajdrowski.tracker_domain.model.TrackedFood
import pl.dnajdrowski.tracker_domain.repository.TrackerRepository
import java.time.LocalDate

class GetFoodsForDate(
    private val repository: TrackerRepository
) {
    operator fun invoke(
      date: LocalDate
    ): Flow<List<TrackedFood>> {
        return repository.getFoodsForDate(date)
    }
}