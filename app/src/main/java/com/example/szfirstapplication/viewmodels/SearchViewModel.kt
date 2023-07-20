package com.example.szfirstapplication.viewmodels

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.szfirstapplication.screens.SearchWidgetState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SearchViewModel
@Inject constructor() : ViewModel() {

    private val _searchWidgetState = mutableStateOf(SearchWidgetState.CLOSED)
    val searchWidgetState: State<SearchWidgetState> = _searchWidgetState

    fun updateSearchWidgetState(state: SearchWidgetState) {
        _searchWidgetState.value = state
    }


    private val _searchTextState = mutableStateOf("")
    val searchTextState: State<String> = _searchTextState

    fun updateSearchTextState(state: String) {
        _searchTextState.value = state
    }
}