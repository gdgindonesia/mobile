package id.gdg.app.stub

import id.gdg.chapter.data.local.ChapterSelectionLocalStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow

class ChapterSelectionLocalStoreStub : ChapterSelectionLocalStore {

    private var _flow = MutableStateFlow(0)

    override suspend fun setChapterId(chapterId: Int) {
        _flow.tryEmit(chapterId)
    }

    override fun getCurrentChapterId() = _flow
}