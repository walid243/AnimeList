package com.example.animelist.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.animelist.AnimeListener
import com.example.animelist.R
import com.example.animelist.databinding.ItemLayoutBinding
import com.example.animelist.model.DataX

class AnimeListAdapter(private val animeList: List<DataX>, val listener: AnimeListener): RecyclerView.Adapter<AnimeListAdapter.ViewHolder>(){
    inner class ViewHolder(view: View): RecyclerView.ViewHolder(view){
        val binding = ItemLayoutBinding.bind(view)
        fun setListener(anime:DataX) {
            binding.root.setOnClickListener {
                listener.onClick(anime)
            }
        }
    }
    private lateinit var context : Context

    override fun onCreateViewHolder(parent:ViewGroup, viewType:Int): ViewHolder {
        context = parent.context
        val view = LayoutInflater.from(context).inflate(R.layout.item_layout, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        println("${animeList.size} <---")
        return animeList.size
    }
    override fun onBindViewHolder(holder: ViewHolder, position:Int) {
        val anime = animeList[position]
        with(holder){
            setListener(anime)
            Glide.with(context).load(anime.images.jpg.imageUrl)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .centerCrop()
                .circleCrop()
                .into(binding.animeImage)
        }
    }
}