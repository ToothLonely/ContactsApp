package dev.toothlonely.contacts.domain

data class Contact(
    val id: String,
    val name: String,
    val phone: String,
    val email: String,
    val photo: String,
)
