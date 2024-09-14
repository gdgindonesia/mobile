package id.gdg.app.data

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.ui.graphics.vector.ImageVector
import id.gdg.app.androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteScope
import kotlin.jvm.JvmInline

val HomepageMenu = SelectedId(0)
val ChapterInfoMenu = SelectedId(1)
val ProfileMenu = SelectedId(2)

object BottomNavBar {

    fun setup(
        scope: NavigationSuiteScope,
        selected: (SelectedId) -> Boolean,
        onClick: (SelectedId) -> Unit
    ) {
        create().forEachIndexed { index, navItem ->
            scope.item(
                icon = { Icon(navItem.icon, contentDescription = navItem.title) },
                label = { Text(navItem.title) },
                selected = selected(navItem.index),
                onClick = { onClick(navItem.index) }
            )
        }
    }

    private fun create() = listOf(
        NavItem(HomepageMenu, "Home", Icons.Filled.Home),
        NavItem(ChapterInfoMenu,"Chapter", Icons.Filled.Info),
        NavItem(ProfileMenu,"Profile", Icons.Filled.Person),
    )

    data class NavItem(
        val index: SelectedId,
        val title: String,
        val icon: ImageVector
    )
}

@JvmInline
value class SelectedId(private val index: Int) {

    override fun toString(): String {
        return index.toString()
    }
}