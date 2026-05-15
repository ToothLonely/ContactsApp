package dev.toothlonely.contacts.presentation.screen.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.toothlonely.contacts.R

@Composable
fun ContactItem(
    name: String?,
    phoneNumber: String?,
    photo: ImageBitmap?,
    isVisible: Boolean = false
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .clip(shape = RoundedCornerShape(20))
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(20.dp),
            modifier = Modifier
                .fillMaxWidth()
        ) {
            if (photo != null) Image(
                bitmap = photo,
                contentDescription = "contact photo"
            )
            else Image(
                painter = painterResource(R.drawable.default_icon),
                contentDescription = "contact photo"
            )
            Text(text = name ?: "")
        }
        if (isVisible) {
            Text(text = phoneNumber ?: "Нет номера")
        }

    }
}

@Composable
@Preview(showBackground = true)
private fun Preview() {
    ContactItem("Arsen", "12345", null, true)
}