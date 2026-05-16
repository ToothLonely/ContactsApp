package dev.toothlonely.contacts.presentation.screen.component

import android.net.Uri
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.toothlonely.contacts.domain.Contact

@Composable
fun LetterList(list: List<Contact>, loadPhoto: (photo: Uri?) -> ImageBitmap?) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clip(shape = RoundedCornerShape(30.dp))
            .background(MaterialTheme.colorScheme.primary)
    ) {
        list.forEachIndexed { index, contact ->
            with(contact) {
                ContactItem(
                    name = this.name,
                    phoneNumber = this.phone,
                    photo = loadPhoto(this.photo)
                )

                if (index < list.lastIndex) {
                    HorizontalDivider(
                        thickness = 1.dp,
                        color = MaterialTheme.colorScheme.tertiary,
                        modifier = Modifier.padding(
                            start = 70.dp,
                            end = 30.dp,
                        )
                    )
                }
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
private fun Preveiew() {
    LetterList(emptyList()) { null }
}