package dev.toothlonely.contacts.di

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import dev.toothlonely.contacts.data.ContactsProvider
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ProvidesModule {

    @Provides
    @Singleton
    fun provideProvider(@ApplicationContext context: Context) =
        ContactsProvider(context.contentResolver)
}