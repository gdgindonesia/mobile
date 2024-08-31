package id.gdg.app.common

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import id.gdg.app.ui.AppEvent

@OptIn(ExperimentalStdlibApi::class)
abstract class UpdateableViewModel() : ViewModel() {

    abstract fun updates(): List<Update>

    fun setupLoop() {
        updates()
            .map { it as UpdateScope }
            .map {
                it.shouldUseViewModelScope(viewModelScope)
                addCloseable(it)
            }
    }

    fun eventHandlers(event: AppEvent) =
        updates().forEach { it.handleEvent(event) }
}