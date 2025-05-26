package com.dst511s.dst_skillconnect.unsorted.tka

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.dst511s.dst_skillconnect.navigation.SkillConnectNavHost
import com.dst511s.dst_skillconnect.ui.theme.DST_SkillConnectTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DST_SkillConnectTheme {
               Surface(
                   modifier = Modifier.fillMaxSize(),
                   color = MaterialTheme.colorScheme.background
               ) {
                   SkillConnectApp()
               }
            }
        }
    }
}

@Composable
fun SkillConnectApp(){
    val navController = rememberNavController()
    SkillConnectNavHost(navController = navController)
}
