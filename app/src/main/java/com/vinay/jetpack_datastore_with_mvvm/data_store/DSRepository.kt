package com.vinay.jetpack_datastore_with_mvvm.data_store

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.vinay.jetpack_datastore_with_mvvm.model.User
import kotlinx.coroutines.flow.map

/**
 * Created by vinaymishra on 27,March,2022
 */
class DSRepository(private val context : Context) : UserInterface {
    private val userData = "UserDataBase"
    val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = userData)

    companion object{
        val name = stringPreferencesKey("NAME")
        val phoneNumber = stringPreferencesKey("PHONE_NUMBER")
        val email = stringPreferencesKey("EMAIL")
    }

    override suspend fun setUserData(user: User) {
        context.dataStore.edit {
            it[name] = user.name
            it[phoneNumber] = user.phone
            it[email] = user.email
        }
    }

    override suspend fun fetchUserData() = context.dataStore.data
            .map {
                user ->
                User(
                name = user[name]?:"",
                phone = user[phoneNumber]?:"",
                email =user[email]?:""
                )
            }

}