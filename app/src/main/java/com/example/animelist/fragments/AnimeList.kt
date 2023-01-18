package com.example.animelist.fragments

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.animelist.AnimeListener
import com.example.animelist.R
import com.example.animelist.adapters.AnimeListAdapter
import com.example.animelist.view_models.AnimeListViewModel
import com.example.animelist.databinding.FragmentAnimeListBinding
import com.example.animelist.model.Data
import com.example.animelist.model.DataX

class AnimeList : Fragment(), AnimeListener {
    private lateinit var binding: FragmentAnimeListBinding
    private lateinit var viewModel: AnimeListViewModel
    private lateinit var animeListAdapter: AnimeListAdapter
    private lateinit var linearLayoutManager: RecyclerView.LayoutManager
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
        animeListAdapter = AnimeListAdapter(getAnimeList(), this)
        linearLayoutManager = LinearLayoutManager(context)
        binding.recyclerView.apply {
            setHasFixedSize(true)
            layoutManager = linearLayoutManager
            adapter = animeListAdapter
        }
        println("fuera de observer <-----")
        Observer<Data?>{
            println("observer <-----")
            println("${it.data} <-----")
        }

    }
    private fun getAnimeList(): List<DataX> {
        return if (viewModel.data.value != null) {
            viewModel.data.value!!.data
        } else {
            emptyList()
        }
    }

    override fun onClick(anime: DataX) {
//        parentFragmentManager.setFragmentResult(
//            "Anime", bundleOf("anime" to anime)
//        )
//        parentFragmentManager.beginTransaction().apply {
//            replace(R.id.fragmentContainerView, DetailFragment())
//            setReorderingAllowed(true)
//            addToBackStack(null)
//            commit()
//        }
    }
}
