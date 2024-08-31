package id.gdg.app.common

import id.gdg.app.ui.AppEvent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancel
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.EmptyCoroutineContext

interface Update {

    fun handleEvent(event: AppEvent)
}

@OptIn(ExperimentalStdlibApi::class)
interface UpdateScope : AutoCloseable {

    val scope: CoroutineScope

    fun shouldUseViewModelScope(scope: CoroutineScope)
}

class MainUpdateScope : UpdateScope, CoroutineScope {

    private var viewModelScope: CoroutineScope? = null

    override val coroutineContext: CoroutineContext
        get() = try {
            Dispatchers.Main.immediate
        } catch (_: NotImplementedError) {
            EmptyCoroutineContext
        } catch (_: IllegalStateException) {
            EmptyCoroutineContext
        } + SupervisorJob()

    override val scope: CoroutineScope
        get() = viewModelScope ?: this

    override fun shouldUseViewModelScope(scope: CoroutineScope) {
        viewModelScope = scope
    }

    override fun close() {
        coroutineContext.cancel()
    }
}