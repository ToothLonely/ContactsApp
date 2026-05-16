package dev.toothlonely.contacts.presentation.screen

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.toothlonely.contacts.domain.Contact
import dev.toothlonely.contacts.domain.ContactsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject
import androidx.core.net.toUri

@HiltViewModel
class ContactsViewModel @Inject constructor(
    private val repository: ContactsRepository
) : ViewModel() {
    data class State(
        val contacts: Map<Char, List<Contact>> = emptyMap()
    )

    private val _state = MutableStateFlow<State>(State())
    val state = _state.asStateFlow()

    init {
        viewModelScope.launch(Dispatchers.IO) {
            loadContacts()
        }
    }

    private fun loadContacts() {
        _state.update {
            it.copy(contacts = repository.getContacts() ?: emptyMap())
        }
    }

    fun loadPhoto(photo: Uri?) = repository.loadPhoto(photo)

    fun makeCall(context: Context, phoneNumber: String) {
        val intent = Intent(Intent.ACTION_CALL).apply {
            data = "tel:$phoneNumber".toUri()
        }
        context.startActivity(intent)
    }
}