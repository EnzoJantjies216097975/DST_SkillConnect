package com.dst511s.dst_skillconnect.data

import okhttp3.Route

sealed class Screen(val route: String) {
    object Onboarding : Screen("onboarding")
    object Login : Screen("login")
    object Register : Screen("register")
    object UserTypeSelection : Screen("user_type_selection")
    object Home : Screen("home")
    object Profile : Screen("profile")
    object Jobs : Screen("jobs")
    object JobDetail : Screen("job_detail/{jobId}") {
        fun createRoute(jobId: String) = "job_detail/$jobId"
    }
    object SkillAssessment : Screen("skill_assessment/{skillId}") {
        fun createRoute(skillId: String) = "skill_assessment/$skillId"
    }
    object Workshops : Screen("workshops")
}