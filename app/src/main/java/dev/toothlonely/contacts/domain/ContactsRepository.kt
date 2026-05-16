package dev.toothlonely.contacts.domain

import android.net.Uri
import androidx.compose.ui.graphics.ImageBitmap

interface ContactsRepository {

    fun getContacts(): HashMap<Char, MutableList<Contact>>?

    fun loadPhoto(photo: Uri?): ImageBitmap?
}