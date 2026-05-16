package dev.toothlonely.contacts.presentation.screen

import androidx.compose.foundation.background
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import dev.toothlonely.contacts.presentation.screen.component.ContactsList

@Composable
fun ContactsScreen(modifier: Modifier = Modifier) {

    val viewModel = hiltViewModel<ContactsViewModel>()
    val state by viewModel.state.collectAsStateWithLifecycle()

    ContactsList(
        contacts = state.contacts,
        loadPhoto = viewModel::loadPhoto,
        makeCall = viewModel::makeCall,
        modifier = modifier.background(
            color = MaterialTheme.colorScheme.background
        )
    )
}

@Composable
@Preview(showBackground = true)
private fun Preview() {
    ContactsScreen()
}