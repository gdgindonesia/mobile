package id.gdg.ui.androidx.compose.material3.windowsizeclass

@Suppress("ConvertSecondaryConstructorToPrimary") // To mirror android api
expect class WindowSizeClass {
    val widthSizeClass: WindowWidthSizeClass
    val heightSizeClass: WindowHeightSizeClass

    private constructor(
        widthSizeClass: WindowWidthSizeClass,
        heightSizeClass: WindowHeightSizeClass
    )
}