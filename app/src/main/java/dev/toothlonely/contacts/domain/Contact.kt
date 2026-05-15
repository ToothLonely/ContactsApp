package dev.toothlonely.contacts.domain

import android.net.Uri

data class Contact(
    val id: Long? = null,
    val name: String? = null,
    val phone: String? = null,
    val photo: Uri? = null,
)
