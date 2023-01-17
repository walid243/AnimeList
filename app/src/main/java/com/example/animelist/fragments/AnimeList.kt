package com.example.animelist.fragments

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.example.animelist.view_models.AnimeListViewModel
import com.example.animelist.databinding.FragmentAnimeListBinding
import com.example.animelist.model.Data

class AnimeList : Fragment() {
    private lateinit var binding: FragmentAnimeListBinding
    private lateinit var viewModel: AnimeListViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAnimeListBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this)[AnimeListViewModel::class.java]
        println("fuera de observer <-----")
        Observer<Data?>{
            println("observer <-----")
            println("${it} <-----")
        }

    }
}
