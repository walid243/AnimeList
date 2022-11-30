package com.example.animelist

import androidx.lifecycle.ViewModel
import com.example.animelist.repository.Repository

class AnimeListViewModel : ViewModel() {
    val repository = Repository()
}