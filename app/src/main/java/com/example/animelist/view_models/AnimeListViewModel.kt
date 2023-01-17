package com.example.animelist.view_models

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.animelist.model.Anime
import com.example.animelist.model.Data
import com.example.animelist.repository.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class AnimeListViewModel: ViewModel() {
    val data = MutableLiveData<Data?>()
    private val animeRepository = Repository()

    init {
        fetchData()
    }

    private fun fetchData() {
        viewModelScope.launch {
            val animeList = withContext(Dispatchers.IO){
                animeRepository.fetchData()
            }
            data.postValue(animeList)
        }
    }

}