package dev.toothlonely.contacts.presentation.screen.component

import android.net.Uri
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.toothlonely.contacts.domain.Contact
import java.io.InputStream

@Composable
fun ContactsList(
    contacts: Map<Char, List<Contact>>,
    loadPhoto: (photo: Uri?) -> ImageBitmap?,
    modifier: Modifier = Modifier
) {
    LazyColumn(modifier.padding(horizontal = 10.dp)) {
        val sortedKeys = contacts.keys.sortedBy { it }
        sortedKeys.forEach { letter ->
            val list = contacts[letter] ?: emptyList()
            item {
                LetterLabel(
                    letter,
                    modifier = Modifier.padding(bottom = 15.dp, start = 10.dp, top = 30.dp)
                )

                LetterList(list.sortedBy { it.name }, loadPhoto)
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
                Contact(1, "Ars", phone = "123", null),
                Contact(2, "Andrew", phone = "1234", null),
                Contact(3, "Ancelotti", phone = "1235", null),
                Contact(4, "Alex", phone = "1236", null),
            )
        ),
        { null }
    )
}