package com.naga.fetch_rewards_assignment

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
import com.naga.fetch_rewards_assignment.ui_screen.ItemListScreen
import com.naga.fetch_rewards_assignment.ui.theme.FetchrewardsassignmentTheme
import com.naga.fetch_rewards_assignment.viewmodel.ItemViewModel

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge() // Extend content behind system bars for a modern look

        setContent {
            FetchrewardsassignmentTheme {
                // Obtain ViewModel instance scoped to this activity
                val viewModel: ItemViewModel = viewModel()

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
