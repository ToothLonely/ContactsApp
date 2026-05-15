package dev.toothlonely.contacts.domain

interface ContactsRepository {

    fun getContacts(): HashMap<Char, MutableList<Contact>>?

    fun getContactInfo(id: String): Contact

}