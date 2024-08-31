package id.gdg.app.update

import id.gdg.app.common.Update
import id.gdg.app.common.UpdateScope
import id.gdg.app.common.UiState
import id.gdg.app.common.asUiState
import id.gdg.app.ui.AppEvent
import id.gdg.app.ui.state.EventChapterUiModel
import id.gdg.app.ui.state.partial.PreviousEventsUiModel
import id.gdg.app.ui.state.partial.UpcomingEventUiModel
import id.gdg.event.domain.GetPreviousEventUseCase
import id.gdg.event.domain.GetUpcomingEventUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

interface ChapterEventUpdate : Update {

    val eventsUiState: Flow<EventChapterUiModel>
}

class ChapterEventUpdateImpl(
    private val upcomingEventUseCase: GetUpcomingEventUseCase,
    private val previousEventUseCase: GetPreviousEventUseCase,
    private val updateScope: UpdateScope
) : ChapterEventUpdate, UpdateScope by updateScope {

    private var _upcomingEvent = MutableStateFlow(UpcomingEventUiModel.Empty)
    private var _previousEvents = MutableStateFlow(PreviousEventsUiModel.Empty)

    override val eventsUiState: Flow<EventChapterUiModel>
        get() = combine(
            _upcomingEvent,
            _previousEvents
        ) { upcoming, previous ->
            EventChapterUiModel(upcoming, previous)
        }.flowOn(Dispatchers.Default)

    override fun handleEvent(event: AppEvent) {
        when(event) {
            is AppEvent.FetchPreviousEvent -> fetchPreviousEvent(event.chapterId)
            is AppEvent.FetchUpcomingEvent -> fetchUpcomingEvents(event.chapterId)
            else -> Unit
        }
    }

    private fun fetchPreviousEvent(chapterId: Int) {
        _previousEvents.update { it.copy(state = UiState.Loading) }

        scope.launch {
            val result = previousEventUseCase(chapterId)

            _previousEvents.update {
                it.copy(
                    state = result.asUiState(),
                    data = result.getOrNull() ?: emptyList()
                )
            }
        }
    }

    private fun fetchUpcomingEvents(chapterId: Int) {
        _upcomingEvent.update { it.copy(state = UiState.Loading) }

        scope.launch {
            val result = upcomingEventUseCase(chapterId)

            _upcomingEvent.update {
                it.copy(
                    state = result.asUiState(),
                    data = result.getOrNull()
                )
            }
        }
    }
}