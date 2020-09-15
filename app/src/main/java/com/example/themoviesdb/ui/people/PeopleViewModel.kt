package com.example.themoviesdb.ui.people

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.themoviesdb.data.DataRepository
import com.example.themoviesdb.data.Resource
import com.example.themoviesdb.data.models.People
import com.example.themoviesdb.data.models.PeopleResponse
import com.example.themoviesdb.ui.base.BaseViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

class PeopleViewModel @Inject constructor(private val dataManager: DataRepository) :
    BaseViewModel() {
    val peopleLiveDataPrivate = MutableLiveData<Resource<People>>()
    val peopleLiveData: LiveData<Resource<People>> get() = peopleLiveDataPrivate

    fun getPeople() {
        viewModelScope.launch {
            peopleLiveDataPrivate.value = Resource.Loading()
            dataManager.getPeople().collect {
                peopleLiveDataPrivate.value = it
            }
        }
    }
}