package com.example.themoviesdb.ui.details

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.themoviesdb.data.DataRepository
import com.example.themoviesdb.data.Resource
import com.example.themoviesdb.data.models.People
import com.example.themoviesdb.data.models.PersonImages
import com.example.themoviesdb.ui.base.BaseViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

class PersonDetailsViewModel@Inject constructor(private val dataManager: DataRepository): BaseViewModel() {
    val personImagesLiveDataPrivate = MutableLiveData<Resource<PersonImages>>()
    val personImagesLiveData: LiveData<Resource<PersonImages>> get() = personImagesLiveDataPrivate

    fun getPeople(id:String) {
        viewModelScope.launch {
            personImagesLiveDataPrivate.value = Resource.Loading()
            dataManager.getPersonImages(id).collect{
                personImagesLiveDataPrivate.value = it
            }

        }
    }
}