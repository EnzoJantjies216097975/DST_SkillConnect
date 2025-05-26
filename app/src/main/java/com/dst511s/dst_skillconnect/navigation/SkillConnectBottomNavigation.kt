package com.dst511s.dst_skillconnect.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Chat
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.School
import androidx.compose.material.icons.filled.Work
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import com.dst511s.dst_skillconnect.unsorted.data.Screen
import com.dst511s.dst_skillconnect.unsorted.data.BottomNavItem

@Composable
fun SkillConnectBottomNavigation(
    navController: NavController,
    modifier: Modifier = Modifier
) {
    val bottomNavItems = listOf(
        BottomNavItem(
            route = Screen.Home.route,
            icon = Icons.Default.Home,
            selectedIcon = Icons.Default.Home,
            label = "Home"
        ),
        BottomNavItem(
            route = Screen.Jobs.route,
            icon = Icons.Default.Work,
            selectedIcon = Icons.Default.Work,
            label = "Jobs"
        ),
        BottomNavItem(
            route = Screen.Workshops.route,
            icon = Icons.Default.School,
            selectedIcon = Icons.Default.School,
            label = "Learn"
        ),
        BottomNavItem(
            route = "messages", // This would be a new screen not included in the starter code
            icon = Icons.AutoMirrored.Filled.Chat,
            selectedIcon = Icons.AutoMirrored.Filled.Chat,
            label = "Messages"
        ),
        BottomNavItem(
            route = Screen.Profile.route,
            icon = Icons.Default.Person,
            selectedIcon = Icons.Default.Person,
            label = "Profile"
        )
    )

    NavigationBar(
        modifier = modifier
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentDestination = navBackStackEntry?.destination

        bottomNavItems.forEach { item ->
            val selected = currentDestination?.hierarchy?.any { it.route == item.route } == true

            NavigationBarItem(
                icon = {
                    Icon(
                        imageVector = if (selected) item.selectedIcon else item.icon,
                        contentDescription = item.label
                    )
                },
                label = { Text(item.label) },
                selected = selected,
                onClick = {
                    navController.navigate(item.route) {
                        // Pop up to the start destination of the graph to
                        // avoid building up a large stack of destinations
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        // Avoid multiple copies of the same destination when
                        // reselecting the same item
                        launchSingleTop = true
                        // Restore state when reselecting a previously selected item
                        restoreState = true
                    }
                }
            )
        }
    }
}