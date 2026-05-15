package dev.toothlonely.contacts.presentation.screen.component

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.toothlonely.contacts.domain.Contact

@Composable
fun ContactsList(contacts: Map<Char, List<Contact>>, modifier: Modifier = Modifier) {
    LazyColumn(modifier) {
        contacts.forEach { (letter, list) ->
            item {
                LetterLabel(
                    letter,
                    modifier = Modifier.padding(bottom = 30.dp, start = 10.dp, top = 15.dp)
                )
            }

            items(list) { contact ->
                with(contact) {
                    ContactItem(name = name, phoneNumber = phone, photo = null, true)
                }
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
private fun Preview() {
    ContactsList(
        mapOf(
            'A' to listOf(
                Contact(0, "Ars", phone = "123", null),
                Contact(0, "BArs", phone = "1234", null),
                Contact(0, "CArs", phone = "1235", null),
                Contact(0, "WArs", phone = "1236", null),
            )
        )

    )
}