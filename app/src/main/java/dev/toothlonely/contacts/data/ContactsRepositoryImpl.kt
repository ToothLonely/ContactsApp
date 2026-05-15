package dev.toothlonely.contacts.data

import android.content.ContentUris
import android.provider.ContactsContract.Contacts
import dev.toothlonely.contacts.domain.Contact
import dev.toothlonely.contacts.domain.ContactsRepository

class ContactsRepositoryImpl(
    private val contactsProvider: ContactsProvider
) : ContactsRepository {
    override fun getContacts(): List<Contact>? {
        val names = contactsProvider.getStructuredNames() ?: return null
        val phones = contactsProvider.getPhoneNumbers() ?: return null
        val contacts = mutableListOf<Contact>()

        var counterId = 0L
        for (id in names.keys) {
            val currentPhones = phones[id] ?: emptyList()
            for (phone in currentPhones) {
                contacts.add(
                    Contact(
                        id = counterId++,
                        name = names[id],
                        phone = phone,
                        photo = ContentUris.withAppendedId(Contacts.CONTENT_URI, id)
                    )
                )
            }
        }
        return contacts
    }

    override fun getContactInfo(id: String): Contact {
        TODO("Not yet implemented")
    }

}
