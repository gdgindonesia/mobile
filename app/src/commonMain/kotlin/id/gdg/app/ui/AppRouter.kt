@file:Suppress("MemberVisibilityCanBePrivate")

package id.gdg.app.ui

import kotlin.jvm.JvmInline

sealed class AppRouter(val route: Path) {

    data object Splash : AppRouter(Path("splash"))
    data object Onboarding : AppRouter(Path("onboarding"))
    data object Home : AppRouter(Path("home"))
    data object EventDetail : AppRouter(Path("detail/{${ARG_EVENT_ID}}"))

    override fun toString(): String {
        return "gdg://$route"
    }

    companion object {
        const val ARG_EVENT_ID = "eventId"
    }
}

@JvmInline
value class Path(private val value: String) {

    fun param(param: String): String {
        return param(arrayOf(param))
    }

    fun param(args: Array<String>): String {
        var result = value
        val regex = Regex("\\{([^}]+)\\}")
        val matches = regex.findAll(value)
        if (matches.any()) {
            matches.forEachIndexed { index, match ->
                result = result.replace(match.value, args[index])
            }
        }

        return result
    }

    override fun toString() = value
}