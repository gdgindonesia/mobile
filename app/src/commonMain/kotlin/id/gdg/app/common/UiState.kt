package id.gdg.app.common

sealed class UiState {
    data object Success : UiState()
    data object Loading : UiState()
    data class Fail(val error: Throwable?) : UiState()

    val isSuccess: Boolean
        get() = this == Success

    val isLoading: Boolean
        get() = this == Loading

    val isFail: Boolean
        get() = this is Fail
}

fun <T> Result<T>.asUiState() = if (isSuccess) {
    UiState.Success
} else {
    UiState.Fail(this.exceptionOrNull())
}
