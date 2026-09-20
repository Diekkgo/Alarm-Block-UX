package com.example.alarmblock

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.alarmblock.data.AlarmDraftState
import com.example.alarmblock.navigation.AlarmBlockRoutes
import com.example.alarmblock.ui.screens.HomeScreen
import com.example.alarmblock.ui.screens.NewAlarmConfirmationScreen
import com.example.alarmblock.ui.screens.NewAlarmLimitsScreen
import com.example.alarmblock.ui.screens.NewAlarmSetupScreen
import com.example.alarmblock.ui.screens.StartAlarmScreen
import com.example.alarmblock.ui.theme.AlarmBlockTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AlarmBlockTheme {
                val navController = rememberNavController()
                // Hoisted once so the values chosen in Setup/Limits survive
                // navigating between the wizard's steps.
                val alarmDraft = remember { AlarmDraftState() }

                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    NavHost(
                        navController = navController,
                        startDestination = AlarmBlockRoutes.Home,
                        modifier = Modifier.padding(innerPadding),
                    ) {
                        composable(AlarmBlockRoutes.Home) {
                            HomeScreen(
                                onCreateAlarm = {
                                    alarmDraft.reset()
                                    navController.navigate(AlarmBlockRoutes.NewAlarmSetup)
                                },
                                onSimulateAlarm = {
                                    navController.navigate(AlarmBlockRoutes.StartAlarm)
                                },
                            )
                        }
                        composable(AlarmBlockRoutes.NewAlarmSetup) {
                            NewAlarmSetupScreen(
                                draft = alarmDraft,
                                onBack = { navController.popBackStack() },
                                onNext = { navController.navigate(AlarmBlockRoutes.NewAlarmLimits) },
                            )
                        }
                        composable(AlarmBlockRoutes.NewAlarmLimits) {
                            NewAlarmLimitsScreen(
                                draft = alarmDraft,
                                onBack = { navController.popBackStack() },
                                onSave = { navController.navigate(AlarmBlockRoutes.NewAlarmConfirmation) },
                            )
                        }
                        composable(AlarmBlockRoutes.NewAlarmConfirmation) {
                            NewAlarmConfirmationScreen(
                                draft = alarmDraft,
                                onGoHome = {
                                    navController.navigate(AlarmBlockRoutes.Home) {
                                        popUpTo(AlarmBlockRoutes.Home) { inclusive = true }
                                    }
                                },
                            )
                        }
                        composable(AlarmBlockRoutes.StartAlarm) {
                            StartAlarmScreen(
                                onTurnOff = {
                                    navController.popBackStack()
                                },
                                onSnooze = {
                                    navController.popBackStack()
                                },
                            )
                        }
                    }
                }
            }
        }
    }
}
