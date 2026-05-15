package dev.toothlonely.contacts.presentation.screen

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import dev.toothlonely.contacts.data.ContactsProvider
import dev.toothlonely.contacts.data.ContactsRepositoryImpl
import dev.toothlonely.contacts.domain.Contact
import dev.toothlonely.contacts.presentation.screen.component.ContactsList

@Composable
fun ContactsScreen(modifier: Modifier = Modifier) {
    val context = LocalContext.current
    val resolver = context.contentResolver
    val provider = ContactsProvider(resolver)
    val repository = ContactsRepositoryImpl(provider)
    val contacts = repository.getContacts() ?: emptyMap<Char, List<Contact>>()

    ContactsList(contacts, modifier)
}

@Composable
@Preview(showBackground = true)
private fun Preview() {
    ContactsScreen()
}