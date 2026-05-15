package dev.toothlonely.contacts.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dev.toothlonely.contacts.data.ContactsRepositoryImpl
import dev.toothlonely.contacts.domain.ContactsRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface BindsModule {
    @Binds
    @Singleton
    fun bindRepository(impl: ContactsRepositoryImpl): ContactsRepository
}