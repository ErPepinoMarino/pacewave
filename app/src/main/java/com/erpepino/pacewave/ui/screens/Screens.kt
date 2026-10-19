package com.erpepino.pacewave.ui.screens

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.erpepino.pacewave.R

@Composable
fun HomeScreen(
    onNewTraining: () -> Unit,
    onStatistics: () -> Unit,
    onExportData: () -> Unit,
) {
    Scaffold { contentPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(contentPadding)
                .padding(horizontal = 24.dp, vertical = 32.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
        ) {
            Spacer(modifier = Modifier.height(28.dp))
            Text(
                text = stringResource(R.string.home_title),
                style = MaterialTheme.typography.headlineLarge,
            )
            Text(
                text = stringResource(R.string.home_tagline),
                style = MaterialTheme.typography.bodyLarge,
            )
            Spacer(modifier = Modifier.height(20.dp))
            Button(onClick = onNewTraining, modifier = Modifier.fillMaxWidth()) {
                Text(stringResource(R.string.new_training))
            }
            OutlinedButton(onClick = onStatistics, modifier = Modifier.fillMaxWidth()) {
                Text(stringResource(R.string.statistics))
            }
            OutlinedButton(onClick = onExportData, modifier = Modifier.fillMaxWidth()) {
                Text(stringResource(R.string.export_data))
            }
        }
    }
}

@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun EditorScreen(onBack: () -> Unit, onContinue: () -> Unit) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(stringResource(R.string.editor_title)) },
                navigationIcon = { BackButton(onClick = onBack) },
            )
        },
    ) { contentPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(contentPadding)
                .padding(24.dp),
            verticalArrangement = Arrangement.spacedBy(20.dp),
        ) {
            Text(stringResource(R.string.editor_placeholder))
            Button(onClick = onContinue) {
                Text(stringResource(R.string.open_live_race))
            }
        }
    }
}

@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun RaceScreen(onBack: () -> Unit) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(stringResource(R.string.race_title)) },
                navigationIcon = { BackButton(onClick = onBack) },
            )
        },
    ) { contentPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(contentPadding)
                .padding(24.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
        ) {
            Text(stringResource(R.string.ready), style = MaterialTheme.typography.titleLarge)
            Text(stringResource(R.string.race_placeholder))
        }
    }
}

@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun PlaceholderScreen(
    @StringRes titleRes: Int,
    @StringRes messageRes: Int,
    onBack: () -> Unit,
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(stringResource(titleRes)) },
                navigationIcon = { BackButton(onClick = onBack) },
            )
        },
    ) { contentPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(contentPadding)
                .padding(24.dp),
            verticalArrangement = Arrangement.spacedBy(20.dp),
        ) {
            Text(stringResource(messageRes))
        }
    }
}

@Composable
private fun BackButton(onClick: () -> Unit) {
    androidx.compose.material3.TextButton(onClick = onClick) {
        Text(stringResource(R.string.back))
    }
}
