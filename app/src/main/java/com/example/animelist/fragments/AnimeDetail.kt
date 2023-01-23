package com.example.animelist.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.animelist.databinding.FragmentAnimeDetailBinding
import com.example.animelist.model.Anime


class AnimeDetail : Fragment() {

    private lateinit var binding: FragmentAnimeDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(
        inflater: android.view.LayoutInflater, container: android.view.ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAnimeDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        parentFragmentManager.setFragmentResultListener("anime", this
        ) { _, result ->
            val anime = result.getParcelable<Anime>("anime")!!
            Glide.with(binding.root).load(anime.images.webp.imageUrl).into(binding.imgPhoto)
            binding.textViewTitle.text = anime.title
            binding.textViewDescription.text = anime.synopsis
            binding.textViewDescription.movementMethod = android.text.method.ScrollingMovementMethod()
        }
    }


}