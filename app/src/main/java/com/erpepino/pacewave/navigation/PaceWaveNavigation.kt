package com.erpepino.pacewave.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.navigation3.runtime.NavEntry
import androidx.navigation3.ui.NavDisplay
import com.erpepino.pacewave.ui.screens.EditorScreen
import com.erpepino.pacewave.ui.screens.HomeScreen
import com.erpepino.pacewave.ui.screens.PlaceholderScreen
import com.erpepino.pacewave.ui.screens.RaceScreen

private data object HomeRoute
private data object EditorRoute
private data object RaceRoute
private data object StatisticsRoute
private data object ExportRoute

@Composable
fun PaceWaveNavigation() {
    val backStack = remember { mutableStateListOf<Any>(HomeRoute) }

    NavDisplay(
        backStack = backStack,
        onBack = { if (backStack.size > 1) backStack.removeLastOrNull() },
        entryProvider = { route ->
            when (route) {
                HomeRoute -> NavEntry(route) {
                    HomeScreen(
                        onNewTraining = { backStack.add(EditorRoute) },
                        onStatistics = { backStack.add(StatisticsRoute) },
                        onExportData = { backStack.add(ExportRoute) },
                    )
                }

                EditorRoute -> NavEntry(route) {
                    EditorScreen(
                        onBack = { backStack.removeLastOrNull() },
                        onContinue = { backStack.add(RaceRoute) },
                    )
                }

                RaceRoute -> NavEntry(route) {
                    RaceScreen(onBack = { backStack.removeLastOrNull() })
                }

                StatisticsRoute -> NavEntry(route) {
                    PlaceholderScreen(
                        titleRes = com.erpepino.pacewave.R.string.statistics,
                        messageRes = com.erpepino.pacewave.R.string.statistics_placeholder,
                        onBack = { backStack.removeLastOrNull() },
                    )
                }

                ExportRoute -> NavEntry(route) {
                    PlaceholderScreen(
                        titleRes = com.erpepino.pacewave.R.string.export_data,
                        messageRes = com.erpepino.pacewave.R.string.export_placeholder,
                        onBack = { backStack.removeLastOrNull() },
                    )
                }

                else -> error("Unknown navigation route: $route")
            }
        },
    )
}
