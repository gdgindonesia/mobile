package id.gdg.app

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import id.gdg.app.di.ViewModelFactory
import id.gdg.app.ui.AppEvent
import id.gdg.app.ui.AppRouter
import id.gdg.app.ui.screen.EventDetailScreen
import id.gdg.app.ui.screen.MainScreen
import id.gdg.app.ui.screen.OnboardingScreen
import id.gdg.app.ui.screen.SplashScreen

@Composable
fun AppContent(
    viewModel: AppViewModel = ViewModelFactory.create(),
    navController: NavHostController = rememberNavController()
) {
    val uiState by viewModel.uiState.collectAsState()
    val detailUiState by viewModel.eventDetailUiState.collectAsState()

    Scaffold { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = AppRouter.OnboardingRoute, //defaultRoute(state.activeChapterId),
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            composable(route = AppRouter.SplashRoute) {
                SplashScreen {
                    navController.navigateTo(
                        from = AppRouter.Splash,
                        to = AppRouter.Onboarding
                    )
                }
            }

            composable(route = AppRouter.OnboardingRoute) {
                OnboardingScreen(
                    chapterList = uiState.chapterUiState.chapters,
                    onChapterSelected = { chapterId ->
                        viewModel.sendEvent(AppEvent.ChangeChapterId(chapterId))
                    },
                    navigateToMainScreen = {
                        navController.navigateTo(
                            from = AppRouter.Onboarding,
                            to = AppRouter.Home
                        )
                    }
                )
            }

            composable(route = AppRouter.HomeRoute) {
                MainScreen(
                    uiState = uiState,
                    detailUiState = detailUiState,
                    onSendEvent = {
                        viewModel.sendEvent(it)
                    },
                    navigateToDetailScreen = { eventId ->
                        navController.navigate(AppRouter.constructEventDetailRoute(eventId))
                    }
                )
            }

            composable(
                route = AppRouter.EventDetailRoute,
                arguments = listOf(navArgument(AppRouter.ArgumentEventId) { type = NavType.StringType })
            ) { backStackEntry ->
                val eventId = backStackEntry.arguments?.getString(AppRouter.ArgumentEventId).orEmpty()

                EventDetailScreen(
                    model = detailUiState,
                    onSendEvent = { viewModel.sendEvent(it) },
                    eventId = eventId
                )
            }
        }
    }
}

private fun NavHostController.navigateTo(from: AppRouter? = null, to: AppRouter) {
    navigate(to.route) {
        if (from != null) {
//            popUpTo(from.route) {
//                inclusive = true
//            }
        }
    }
}

private fun defaultRoute(chapterId: Int) =
    if (chapterId > 0) AppRouter.Home.route else AppRouter.Splash.route