package id.gdg.app

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import id.gdg.app.di.ViewModelFactory
import id.gdg.app.ui.ParentScreen
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
            safeComposable<SplashScreenRouter> {
                SplashScreen {
                    navController.navigate(OnboardingRouter) {
                        popUpTo(SplashScreenRouter) {
                            inclusive = true
                        }
                    }
                }
            }

            safeComposable<OnboardingRouter> {
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

            safeComposable<MainRouter> {
                ParentScreen(
                    mainScreen = { onEventDetailClicked ->
                        MainScreen(
                            viewModel = mainViewModel,
                            onEventDetailClicked = onEventDetailClicked
                        )
                    },
                    detailScreen = { eventId, onCloseSidePanel ->
                        EventDetailScreen(
                            viewModel = eventDetailViewModel,
                            eventId = eventId,
                            fromPanel = true,
                            onBack = {
                                onCloseSidePanel()
                            }
                        )
                    },
                    navigateToDetailScreen = { eventId ->
                        navController.navigate(EventDetailRouter(eventId))
                    }
                )
            }

            safeComposable<EventDetailRouter> {
                val eventDetail = it.toRoute<EventDetailRouter>()

                EventDetailScreen(
                    viewModel = eventDetailViewModel,
                    eventId = eventDetail.eventId,
                    fromPanel = false,
                    onBack = {
                        navController.navigateUp()
                    }
                )
            }
        }
    }
}
