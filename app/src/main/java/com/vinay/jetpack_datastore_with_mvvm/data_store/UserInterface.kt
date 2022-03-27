package com.vinay.jetpack_datastore_with_mvvm.data_store
import com.vinay.jetpack_datastore_with_mvvm.model.User
import kotlinx.coroutines.flow.Flow

/**
 * Created by vinaymishra on 27,March,2022
 */
interface UserInterface {
    suspend fun setUserData(user : User)
    suspend fun fetchUserData(): Flow<User>
}