package dev.toothlonely.contacts.presentation

import android.Manifest
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import dagger.hilt.android.AndroidEntryPoint
import dev.toothlonely.contacts.presentation.screen.ContactsScreen
import dev.toothlonely.contacts.presentation.screen.HintScreen
import dev.toothlonely.contacts.presentation.theme.ContactsTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ContactsTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    val permission = Manifest.permission.READ_CONTACTS
                    var isGranted by remember {
                        mutableStateOf(false)
                    }

                    val launcher = rememberLauncherForActivityResult(
                        contract = ActivityResultContracts.RequestPermission()
                    ) { answer ->
                        isGranted = answer
                    }

                    LaunchedEffect(Unit) {
                        launcher.launch(permission)
                    }
                    if(isGranted) ContactsScreen(modifier = Modifier.padding(innerPadding))
                    else HintScreen()
                }
            }
        }
    }
}