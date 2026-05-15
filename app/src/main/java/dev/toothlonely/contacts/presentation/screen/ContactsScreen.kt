package dev.toothlonely.contacts.presentation.screen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import dev.toothlonely.contacts.data.ContactsProvider
import dev.toothlonely.contacts.data.ContactsRepositoryImpl
import dev.toothlonely.contacts.domain.Contact
import dev.toothlonely.contacts.presentation.screen.component.ContactsList

@Composable
fun ContactsScreen(modifier: Modifier = Modifier) {

    val viewModel = hiltViewModel<ContactsViewModel>()
    val state by viewModel.state.collectAsStateWithLifecycle()

    ContactsList(state.contacts, modifier)
}

@Composable
@Preview(showBackground = true)
private fun Preview() {
    ContactsScreen()
}