package id.gdg.app.ui.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import id.gdg.app.common.UiState
import id.gdg.app.common.asUiState
import id.gdg.event.domain.GetEventDetailUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class EventDetailViewModel(
    private val eventDetailUseCase: GetEventDetailUseCase
) : ViewModel() {

    private var _eventDetailUiState = MutableStateFlow(EventDetailUiModel.Empty)
    val eventDetailUiState get() = _eventDetailUiState.asStateFlow()

    fun fetch(eventId: Int) {
        _eventDetailUiState.update { it.copy(state = UiState.Loading) }

        viewModelScope.launch {
            val result = eventDetailUseCase(eventId)

            withContext(Dispatchers.Main) {
                _eventDetailUiState.update {
                    it.copy(
                        state = result.asUiState(),
                        detail = result.getOrNull()
                    )
                }
            }
        }
    }
}