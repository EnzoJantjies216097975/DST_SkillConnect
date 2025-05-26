package com.dst511s.dst_skillconnect.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.dst511s.dst_skillconnect.unsorted.data.Screen
import com.dst511s.dst_skillconnect.features.auth.screens.LoginScreen
import com.dst511s.dst_skillconnect.features.auth.screens.RegisterScreen
import com.dst511s.dst_skillconnect.features.auth.screens.UserTypeSelectionScreen
import com.dst511s.dst_skillconnect.features.home.screens.HomeScreen
import com.dst511s.dst_skillconnect.features.jobs.screens.JobDetailScreen
import com.dst511s.dst_skillconnect.features.jobs.screens.JobsScreen
import com.dst511s.dst_skillconnect.features.onboarding.screens.OnboardingScreen
import com.dst511s.dst_skillconnect.features.profile.screens.ProfileScreen
import com.dst511s.dst_skillconnect.features.skills.screens.SkillAssessmentScreen
import com.dst511s.dst_skillconnect.features.workshops.screens.WorkshopsScreen

@Composable
fun SkillConnectNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = Screen.Onboarding.route,
        modifier = modifier
    ) {
        composable(Screen.Onboarding.route) {
            OnboardingScreen(
                onGetStartedClick = {
                    navController.navigate(Screen.Register.route)
                },
                onLoginClick = {
                    navController.navigate(Screen.Login.route)
                }
            )
        }

        composable(Screen.Login.route) {
            LoginScreen(
                onLoginSuccess = {
                    navController.navigate(Screen.Home.route) {
                        popUpTo(Screen.Onboarding.route) { inclusive = true }
                    }
                },
                onRegisterClick = {
                    navController.navigate(Screen.Register.route)
                }
            )
        }

        composable(Screen.Register.route) {
            RegisterScreen(
                onRegisterSuccess = {
                    navController.navigate(Screen.UserTypeSelection.route)
                },
                onLoginClick = {
                    navController.navigate(Screen.Login.route)
                }
            )
        }

        composable(Screen.UserTypeSelection.route) {
            UserTypeSelectionScreen(
                onUserTypeSelected = { userType ->
                    // Save user type and navigate to home
                    navController.navigate(Screen.Home.route) {
                        popUpTo(Screen.Onboarding.route) { inclusive = true }
                    }
                }
            )
        }

        composable(Screen.Home.route) {
            HomeScreen(
                onNavigateToJobs = {
                    navController.navigate(Screen.Jobs.route)
                },
                onNavigateToWorkshops = {
                    navController.navigate(Screen.Workshops.route)
                },
                onNavigateToProfile = {
                    navController.navigate(Screen.Profile.route)
                }
            )
        }

        composable(Screen.Profile.route) {
            ProfileScreen(
                onNavigateBack = {
                    navController.popBackStack()
                },
                onSkillAssessmentClick = { skillId ->
                    navController.navigate(Screen.SkillAssessment.createRoute(skillId))
                }
            )
        }

        composable(Screen.Jobs.route) {
            JobsScreen(
                onJobClick = { jobId ->
                    navController.navigate(Screen.JobDetail.createRoute(jobId))
                },
                onNavigateBack = {
                    navController.popBackStack()
                }
            )
        }

        composable(Screen.JobDetail.route) { backStackEntry ->
            val jobId = backStackEntry.arguments?.getString("jobId") ?: ""
            JobDetailScreen(
                jobId = jobId,
                onNavigateBack = {
                    navController.popBackStack()
                },
                onApplyClick = { /* Handle apply process */ }
            )
        }

        composable(Screen.SkillAssessment.route) { backStackEntry ->
            val skillId = backStackEntry.arguments?.getString("skillId") ?: ""
            SkillAssessmentScreen(
                skillId = skillId,
                onNavigateBack = {
                    navController.popBackStack()
                },
                onAssessmentComplete = { /* Handle assessment completion */ }
            )
        }

        composable(Screen.Workshops.route) {
            WorkshopsScreen(
                onNavigateBack = {
                    navController.popBackStack()
                },
                onWorkshopClick = { /* Handle workshop selection */ }
            )
        }
    }
}