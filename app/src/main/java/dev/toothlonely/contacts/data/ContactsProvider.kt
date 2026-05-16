package dev.toothlonely.contacts.data

import android.content.ContentResolver
import android.database.Cursor
import android.graphics.BitmapFactory
import android.net.Uri
import android.provider.ContactsContract
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.asImageBitmap

class ContactsProvider(
    private val contentResolver: ContentResolver
) {
    private val sortOrder = ContactsContract.Contacts._ID

    fun getPhoneNumbers(): HashMap<Long, MutableList<String>>? {

        val projection = arrayOf(
            ContactsContract.Data.CONTACT_ID,
            ContactsContract.CommonDataKinds.Phone.NUMBER,
        )

        val phoneCursor = contentResolver.query(
            ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
            projection,
            null,
            null,
            sortOrder
        )

        val map = hashMapOf<Long, MutableList<String>>()

        when (phoneCursor?.count) {
            null -> return null
            0 -> return map
            else -> {
                phoneCursor.use { cursor ->

                    val id = cursor.getColumnIndex(projection[0])
                    val number = cursor.getColumnIndex(projection[1])

                    while (cursor.moveToNext()) {
                        map.getOrPut(cursor.getLong(id)) {
                            mutableListOf()
                        }.add(cursor.getString(number))
                    }
                }
            }
        }
        return map
    }

    fun getStructuredNames(): HashMap<Long, String>? {

        val projection = arrayOf(
            ContactsContract.Contacts._ID,
            ContactsContract.Contacts.DISPLAY_NAME,
        )

        val nameCursor = contentResolver.query(
            ContactsContract.Contacts.CONTENT_URI,
            projection,
            null,
            null,
            sortOrder
        )

        val map = hashMapOf<Long, String>()

        when (nameCursor?.count) {
            null -> return null
            0 -> return map
            else -> {
                nameCursor.use { cursor ->

                    val id = cursor.getColumnIndex(projection[0])
                    val name = cursor.getColumnIndex(projection[1])

                    while (cursor.moveToNext()) {
                        map[cursor.getLong(id)] = cursor.getString(name)
                    }
                }
            }
        }

        return map
    }

    fun openPhoto(photoUri: Uri?): ImageBitmap? {

        if (photoUri == null) return null

        val cursor: Cursor? = contentResolver.query(
            photoUri,
            arrayOf(ContactsContract.Contacts.Photo.PHOTO), null, null, null
        )
        if (cursor == null) return null

        cursor.use { cursor ->
            if (cursor.moveToFirst()) {
                val data = cursor.getBlob(0)
                if (data != null) {
                    return BitmapFactory.decodeByteArray(
                        data,
                        0,
                        data.size
                    ).asImageBitmap()
                }
            }
        }
        return null
    }
}