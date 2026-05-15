package dev.toothlonely.contacts.domain

interface ContactsRepository {

    fun getContacts(): List<Contact>?

    fun getContactInfo(id: String): Contact

}