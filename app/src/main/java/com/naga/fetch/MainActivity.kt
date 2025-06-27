package com.naga.fetch

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.naga.fetch.presentation.ui.screens.ItemListScreen
import com.naga.fetch.presentation.theme.FetchRewardsTheme
import com.naga.fetch.presentation.RewardsViewModel

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge() // Extend content behind system bars for a modern look

        setContent {
            FetchRewardsTheme {
                // Obtain ViewModel instance scoped to this activity
                val viewModel: RewardsViewModel = viewModel()

                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    containerColor = MaterialTheme.colorScheme.background
                ) { innerPadding ->
                    Surface(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding)
                    ) {
                        // Pass ViewModel to composable to observe UI state and render list
                        ItemListScreen(viewModel = viewModel)
                    }
                }
            }
        }
    }
}
