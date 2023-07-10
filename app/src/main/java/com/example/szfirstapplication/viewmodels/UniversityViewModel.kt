package com.example.szfirstapplication.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.szfirstapplication.data.entities.University
import com.example.szfirstapplication.data.repositories.UniversityRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class UniversityViewModel @Inject constructor(
    private val repository: UniversityRepository
) : ViewModel() {

    private val _universitiesList = MutableStateFlow(emptyList<University>())
    val universitiesList: StateFlow<List<University>> = _universitiesList

    init {
        getUniversitiesList()
    }

    private fun getUniversitiesList() = viewModelScope.launch {
        repository.getUniversitiesList().collectLatest {
            _universitiesList.value = it
        }
    }

    fun addUniversity(university: University){
        viewModelScope.launch(Dispatchers.IO) {
            repository.addUniversity(university)
        }
    }
}