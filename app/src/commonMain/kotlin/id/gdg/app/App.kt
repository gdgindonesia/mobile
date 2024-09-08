package id.gdg.app

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import id.gdg.app.di.ViewModelFactory
import id.gdg.app.ui.AppEvent
import id.gdg.app.ui.EventDetailRouter
import id.gdg.app.ui.HomeRouter
import id.gdg.app.ui.OnboardingRouter
import id.gdg.app.ui.ScreenScaffold
import id.gdg.app.ui.SplashScreenRouter
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
            startDestination = SplashScreenRouter,
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            composable<SplashScreenRouter> {
                SplashScreen {
                    navController.navigate(OnboardingRouter) {
                        popUpTo(SplashScreenRouter) {
                            inclusive = true
                        }
                    }
                }
            }

            composable<OnboardingRouter> {
                OnboardingScreen(
                    chapterList = viewModel.chapterList,
                    onChapterSelected = { chapterId ->
                        viewModel.sendEvent(AppEvent.ChangeChapterId(chapterId))
                    },
                    navigateToMainScreen = {
                        navController.navigate(HomeRouter) {
                            popUpTo(OnboardingRouter) {
                                inclusive = true
                            }
                        }
                    }
                )
            }

            composable<HomeRouter> {
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
                        navController.navigate(EventDetailRouter(eventId))
                    }
                )
            }

            composable<EventDetailRouter> {
                val eventDetail = it.toRoute<EventDetailRouter>()

                EventDetailScreen(
                    viewModel = viewModel,
                    eventId = eventDetail.eventId
                )
            }
        }
    }
}
