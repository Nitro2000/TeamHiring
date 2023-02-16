package com.example.teamhiring.storage

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.*
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import androidx.datastore.preferences.core.Preferences
import com.example.teamhiring.data.constants.Constant
import java.io.IOException



class DataStoreManagerImpl(private val context: Context) : DataStoreManager {

    private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = Constant.DATA_STORE_NAME)

    companion object {
        // Recruiter = false,   Employee = true  save data accordingly
        val USER_TYPE = booleanPreferencesKey("user_type")
    }

    override suspend fun <T> put(key: Preferences.Key<T>, value: T) {
        context.dataStore.edit { preferences ->
            preferences[key] = value
        }
    }

    override suspend fun <T> delete(key: Preferences.Key<T>) {
        context.dataStore.edit { preferences ->
            preferences.remove(key)
        }
    }

    override fun <T> get(key: Preferences.Key<T>, defaultValue: T): Flow<T> {
        return context.dataStore.data
            .catch { exception ->
                if (exception is IOException) {
                    emit(emptyPreferences())
                } else {
                    throw exception
                }
            }.map { preferences ->
                preferences[key] ?: defaultValue
            }
    }

    override suspend fun clearData() {
        context.dataStore.edit {
            it.clear()
        }
    }


}