package dev.toothlonely.contacts.presentation.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import dev.toothlonely.contacts.R

@Composable
fun HintScreen(isContactsGranted: Boolean) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Text(
            text =
                if (!isContactsGranted) stringResource(R.string.remind_contact_permission)
                else stringResource(R.string.remind_phone_call_permission)
        )
    }
}

@Composable
@Preview(showBackground = true)
private fun Preview() {
    HintScreen(true)
}
