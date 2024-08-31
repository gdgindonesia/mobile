package id.gdg.app

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
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
import id.gdg.app.ui.ScreenScaffold
import id.gdg.app.ui.screen.EventDetailScreen
import id.gdg.app.ui.screen.MainScreen
import id.gdg.app.ui.screen.OnboardingScreen
import id.gdg.app.ui.screen.SplashScreen

@Composable
fun AppContent(
    viewModel: AppViewModel = ViewModelFactory.create(),
    navController: NavHostController = rememberNavController()
) {
    Scaffold { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = AppRouter.Onboarding.toString(), //defaultRoute(state.activeChapterId),
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            composable(route = AppRouter.Splash.toString()) {
                SplashScreen {
                    navController.navigateTo(
                        from = AppRouter.Splash,
                        to = AppRouter.Onboarding
                    )
                }
            }

            composable(route = AppRouter.Onboarding.toString()) {
                OnboardingScreen(
                    chapterList = viewModel.chapterList,
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

            composable(route = AppRouter.Home.toString()) {
                ScreenScaffold(
                    viewModel = viewModel,
                    mainScreen = { viewModel, onEventDetailClicked ->
                        MainScreen(
                            viewModel = viewModel,
                            onEventDetailClicked = onEventDetailClicked
                        )
                    },
                    detailScreen = { viewModel, eventId ->
                        /**
                         * Need to show the detail screen on same composable screen
                         * due to side-to-side scaffold for tablet nor large screens.
                         */
                        /**
                         * Need to show the detail screen on same composable screen
                         * due to side-to-side scaffold for tablet nor large screens.
                         */
                        EventDetailScreen(
                            viewModel = viewModel,
                            eventId = eventId
                        )
                    },
                    navigateToDetailScreen = { eventId ->
                        navController.navigate(
                            AppRouter.EventDetail.route.param(eventId)
                        )
                    }
                )
            }

            composable(
                route = AppRouter.EventDetail.toString(),
                arguments = listOf(navArgument(AppRouter.ARG_EVENT_ID) { type = NavType.StringType })
            ) { backStackEntry ->
                val eventId = backStackEntry.arguments?.getString(AppRouter.ARG_EVENT_ID).orEmpty()

                EventDetailScreen(
                    viewModel = viewModel,
                    eventId = eventId
                )
            }
        }
    }
}

private fun NavHostController.navigateTo(from: AppRouter? = null, to: AppRouter) {
    navigate(to.route.toString()) {
        if (from != null) {
//            popUpTo(from.route) {
//                inclusive = true
//            }
        }
    }
}

private fun defaultRoute(chapterId: Int) =
    if (chapterId > 0) AppRouter.Home.route else AppRouter.Splash.route