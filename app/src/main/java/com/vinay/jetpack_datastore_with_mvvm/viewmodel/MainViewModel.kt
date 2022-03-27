package com.vinay.jetpack_datastore_with_mvvm.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vinay.jetpack_datastore_with_mvvm.data_store.DSRepository
import com.vinay.jetpack_datastore_with_mvvm.model.User
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

/**
 * Created by vinaymishra on 27,March,2022
 */

@HiltViewModel
class MainViewModel @Inject constructor(private val repo : DSRepository)  : ViewModel() {

    var name : MutableLiveData<String> = MutableLiveData("")
    var phone : MutableLiveData<String> = MutableLiveData("")
    var email : MutableLiveData<String> = MutableLiveData("")

    var userData : MutableLiveData<User> = MutableLiveData()

    fun setData(){
        viewModelScope.launch(Dispatchers.IO) {
            repo.setUserData(
                User(
                    name = name.value?:"",
                    phone = phone.value?:"",
                    email =email.value?:""
                )
            )
        }
    }

    fun getData(){
        viewModelScope.launch(Dispatchers.IO) {
            repo.fetchUserData().collect {
                withContext(Dispatchers.Main){
                    userData.postValue(it)
                }
            }
        }
    }


}