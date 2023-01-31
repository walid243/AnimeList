package com.example.animelist.view_models

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.animelist.model.Anime
import com.example.animelist.repository.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class AnimeListViewModel: ViewModel() {
    val data = MutableLiveData<List<Anime>?>()
    val favData = MutableLiveData<MutableList<Anime>?>()
    private val animeRepository = Repository()

    init {
        fetchData()
        importFavData()
        checkFavData()
    }

    private fun fetchData() {
        viewModelScope.launch {
            val response = withContext(Dispatchers.IO){
               animeRepository.fetchData()
            }
            data.postValue(response)

        }
    }
    private fun importFavData(){
        viewModelScope.launch {
            val response = withContext(Dispatchers.IO){
                animeRepository.importFavData()
            }
            favData.postValue(response)
        }
    }
    private fun checkFavData() {
        viewModelScope.launch {
            data.value?.forEach {
                if (favData.value?.contains(it) == true) {
                    it.isFav = true
                }
            }
            data.postValue(data.value)
        }
    }
}