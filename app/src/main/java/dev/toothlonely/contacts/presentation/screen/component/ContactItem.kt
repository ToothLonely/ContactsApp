package dev.toothlonely.contacts.presentation.screen.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.toothlonely.contacts.R
import dev.toothlonely.contacts.presentation.theme.ContactsTheme

@Composable
fun ContactItem(
    name: String?,
    phoneNumber: String?,
    photo: ImageBitmap?,
) {
    var isVisible by remember { mutableStateOf(false) }

    Column(
        verticalArrangement = Arrangement.spacedBy(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 5.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(20.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 5.dp)
                .clickable {
                    isVisible = !isVisible
                }
        ) {
            if (photo != null) Image(
                bitmap = photo,
                contentDescription = stringResource(R.string.photo_description),
                modifier = Modifier
                    .size(50.dp)
                    .clip(CircleShape)
            )
            else Icon(
                painter = painterResource(R.drawable.default_icon),
                contentDescription = stringResource(R.string.photo_description),
                tint = MaterialTheme.colorScheme.onSurface,
                modifier = Modifier
                    .size(60.dp)
            )

            Text(
                text = name ?: stringResource(R.string.unknown_name),
                color = MaterialTheme.colorScheme.secondary
            )
        }

        if (isVisible) {
            Text(
                text = "Номер телефона: ${phoneNumber ?: stringResource(R.string.unknown_phone)}",
                modifier = Modifier.padding(bottom = 10.dp)
            )
        }

    }
}

@Composable
@Preview(showBackground = true)
private fun Preview() {
    ContactItem("Arsen", "12345", null)
}