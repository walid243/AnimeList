package com.example.animelist.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.animelist.AnimeListener
import com.example.animelist.R
import com.example.animelist.adapters.FavAnimeAdapter
import com.example.animelist.databinding.FragmentAnimeListBinding
import com.example.animelist.model.Anime
import com.example.animelist.view_models.AnimeListViewModel


class LikedList : Fragment(), AnimeListener {

    private lateinit var binding: FragmentAnimeListBinding
    private lateinit var favAnimeListAdapter: FavAnimeAdapter
    private lateinit var linearLayoutManager: RecyclerView.LayoutManager
    private val viewModel: AnimeListViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAnimeListBinding.inflate(inflater,container,false)
        binding.animelistTextView!!.text = "LikedList"
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        favAnimeListAdapter = FavAnimeAdapter(viewModel.favData, this)
        linearLayoutManager = LinearLayoutManager(context)
        binding.recyclerView.apply {
            setHasFixedSize(true)
            layoutManager = linearLayoutManager
            adapter = favAnimeListAdapter
        }
        binding.toLikedListButton.setOnClickListener {
            parentFragmentManager.beginTransaction().apply {
                replace(R.id.fragmentContainerView, AnimeList() )
                setReorderingAllowed(true)
                addToBackStack(null)
                commit()
            }
        }
        binding.searchButton.setOnClickListener {
            parentFragmentManager.beginTransaction().apply {
                replace(R.id.fragmentContainerView, Search())
                setReorderingAllowed(true)
                addToBackStack(null)
                commit()
            }
        }
        viewModel.favData.observe(viewLifecycleOwner, Observer {
            favAnimeListAdapter.notifyDataSetChanged()
            favAnimeListAdapter.favAnimeList = viewModel.favData
        })
    }
    override fun onClick(anime: Anime) {
        parentFragmentManager.setFragmentResult(
            "anime",
            bundleOf("anime" to anime)
        )
        parentFragmentManager.beginTransaction().apply {
            replace(R.id.fragmentContainerView, AnimeDetail())
            setReorderingAllowed(true)
            addToBackStack(null)
            commit()
        }
    }

}