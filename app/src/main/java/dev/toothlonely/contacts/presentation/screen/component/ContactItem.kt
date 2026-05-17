package dev.toothlonely.contacts.presentation.screen.component

import android.content.Context
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
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
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.toothlonely.contacts.R

@Composable
fun ContactItem(
    name: String?,
    phoneNumber: String?,
    photo: ImageBitmap?,
    makeCall: (context: Context, phoneNumber: String) -> Unit
) {
    var isVisible by remember { mutableStateOf(false) }
    val context = LocalContext.current

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Row(
            modifier = Modifier
                .clickable {
                    isVisible = !isVisible
                }
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(10.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 5.dp)
            ) {
                if (photo != null) Image(
                    bitmap = photo,
                    contentDescription = stringResource(R.string.photo_description),
                    modifier = Modifier
                        .size(40.dp)
                        .clip(CircleShape)
                )
                else Icon(
                    painter = painterResource(R.drawable.default_icon),
                    contentDescription = stringResource(R.string.photo_description),
                    tint = MaterialTheme.colorScheme.onSurface,
                    modifier = Modifier
                        .size(50.dp)
                )

                Text(
                    text = name ?: stringResource(R.string.unknown_name),
                    color = MaterialTheme.colorScheme.secondary,
                    modifier = Modifier.padding(vertical = 15.dp)
                )
            }
        }

        AnimatedVisibility(
            visible = isVisible,
            modifier = Modifier
                .clickable {
                    if (phoneNumber != null) makeCall(context, phoneNumber)
                }
        ) {
            val prefix = stringResource(R.string.make_call_prefix)
            Text(
                text = "$prefix ${phoneNumber ?: stringResource(R.string.unknown_phone)}",
            )
        }

    }
}

@Composable
@Preview(showBackground = true)
private fun Preview() {
    ContactItem("Arsen", "12345", null) { context, phoneNumber -> }
}