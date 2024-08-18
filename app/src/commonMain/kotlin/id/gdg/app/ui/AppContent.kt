package id.gdg.app.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import id.gdg.app.AppViewModel
import id.gdg.app.di.ViewModelFactory
import id.gdg.app.ui.screen.MainScreen
import id.gdg.app.ui.screen.OnboardingScreen
import id.gdg.app.ui.screen.SplashScreen
import id.gdg.app.ui.state.AppEvent

@Composable
fun AppContent(
    viewModel: AppViewModel = ViewModelFactory.create(),
    navController: NavHostController = rememberNavController()
) {
    val state by viewModel.state.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.sendEvent(AppEvent.InitActiveChapterId)
    }

    Scaffold { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = defaultRoute(state.activeChapterId),
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            composable(route = AppRouter.Splash.route) {
                SplashScreen {
                    navController.navigateTo(
                        from = AppRouter.Splash,
                        to = AppRouter.Onboarding
                    )
                }
            }

            composable(route = AppRouter.Onboarding.route) {
                OnboardingScreen(
                    chapterList = viewModel.getChapterList(),
                    onChapterSelected = { chapterId ->
                        viewModel.sendEvent(AppEvent.SetActiveChapterId(chapterId))

                        navController.navigateTo(
                            from = AppRouter.Onboarding,
                            to = AppRouter.Home
                        )
                    }
                )
            }

            composable(route = AppRouter.Home.route) {
                MainScreen(
                    state = state,
                    onFetchEventRequested = {
                        viewModel.sendEvent(AppEvent.FetchEvent)
                    }
                )
            }
        }
    }
}

private fun NavHostController.navigateTo(from: AppRouter? = null, to: AppRouter) {
    navigate(to.route) {
        if (from != null) {
            popUpTo(from.route) {
                inclusive = true
            }
        }
    }
}

private fun defaultRoute(chapterId: Int) =
    if (chapterId > 0) AppRouter.Home.route else AppRouter.Splash.route