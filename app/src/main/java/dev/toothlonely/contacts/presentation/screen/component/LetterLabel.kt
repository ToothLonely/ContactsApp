package dev.toothlonely.contacts.presentation.screen.component

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp

@Composable
fun LetterLabel(letter: Char, modifier: Modifier = Modifier) {
    Text(
        text = letter.toString(),
        color = MaterialTheme.colorScheme.secondary,
        fontSize = 20.sp,
        modifier = modifier
    )
}

@Composable
@Preview(showBackground = true)
private fun Preview() {
    LetterLabel('A')
}