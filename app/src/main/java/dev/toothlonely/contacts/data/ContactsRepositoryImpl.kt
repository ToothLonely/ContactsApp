package dev.toothlonely.contacts.data

import android.content.ContentUris
import android.net.Uri
import android.provider.ContactsContract
import android.provider.ContactsContract.Contacts
import dev.toothlonely.contacts.domain.Contact
import dev.toothlonely.contacts.domain.ContactsRepository
import javax.inject.Inject

class ContactsRepositoryImpl @Inject constructor(
    private val contactsProvider: ContactsProvider
) : ContactsRepository {
    override fun getContacts(): HashMap<Char, MutableList<Contact>>? {
        val names = contactsProvider.getStructuredNames() ?: return null
        val phones = contactsProvider.getPhoneNumbers() ?: return null
        val contacts = hashMapOf<Char, MutableList<Contact>>()

        var counterId = 0L
        for (id in names.keys) {

            val currentPhones = phones[id] ?: emptyList()
            val photoUri = Uri.withAppendedPath(
                ContentUris.withAppendedId(Contacts.CONTENT_URI, id),
                Contacts.Photo.CONTENT_DIRECTORY
            )
            val currentName = names[id] ?: "*"

            for (phone in currentPhones) {
                contacts.getOrPut(currentName[0]) {
                    mutableListOf()
                }.add(
                    Contact(
                        id = counterId++,
                        name = names[id],
                        phone = phone,
                        photo = photoUri
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
