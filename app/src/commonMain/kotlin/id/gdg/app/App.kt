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
import id.gdg.app.ui.main.MainEvent
import id.gdg.app.ui.ScreenScaffold
import id.gdg.app.ui.detail.EventDetailRouter
import id.gdg.app.ui.detail.EventDetailScreen
import id.gdg.app.ui.detail.EventDetailViewModel
import id.gdg.app.ui.main.MainRouter
import id.gdg.app.ui.main.MainScreen
import id.gdg.app.ui.main.MainViewModel
import id.gdg.app.ui.onboarding.OnboardingRouter
import id.gdg.app.ui.onboarding.OnboardingScreen
import id.gdg.app.ui.onboarding.OnboardingViewModel
import id.gdg.app.ui.splash.SplashScreen
import id.gdg.app.ui.splash.SplashScreenRouter

@Composable
fun AppContent(
    onboardingViewModel: OnboardingViewModel = ViewModelFactory.onboardingViewModel(),
    mainViewModel: MainViewModel = ViewModelFactory.mainViewModel(),
    eventDetailViewModel: EventDetailViewModel = ViewModelFactory.eventDetailViewModel(),
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
                    viewModel = onboardingViewModel,
                    navigateToMainScreen = {
                        navController.navigate(MainRouter) {
                            popUpTo(OnboardingRouter) {
                                inclusive = true
                            }
                        }
                    }
                )
            }

            composable<MainRouter> {
                ScreenScaffold(
                    mainScreen = { onEventDetailClicked ->
                        MainScreen(
                            viewModel = mainViewModel,
                            onEventDetailClicked = onEventDetailClicked
                        )
                    },
                    detailScreen = { eventId ->
                        /**
                         * Need to show the detail screen on same composable screen
                         * due to side-to-side scaffold for tablet nor large screens.
                         */
                        /**
                         * Need to show the detail screen on same composable screen
                         * due to side-to-side scaffold for tablet nor large screens.
                         */
                        EventDetailScreen(
                            viewModel = eventDetailViewModel,
                            eventId = eventId,
                            onBack = {

                            }
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
                    viewModel = eventDetailViewModel,
                    eventId = eventDetail.eventId,
                    onBack = {

                    }
                )
            }
        }
    }
}
