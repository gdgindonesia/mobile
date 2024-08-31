package id.gdg.app.ui.state

import id.gdg.app.common.UiState
import id.gdg.event.model.EventDetailModel

data class EventDetailUiModel(
    val state: UiState,
    val detail: EventDetailModel? = null
) {

    companion object {
        val Empty get() = EventDetailUiModel(
            state = UiState.Loading,
            detail = null
        )
    }
}