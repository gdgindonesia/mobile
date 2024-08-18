package id.gdg.app.ui.state

import id.gdg.event.model.MultiEventModel

data class AppUiModel(
    val activeChapterId: Int = 0,
    val events: MultiEventModel = MultiEventModel()
)