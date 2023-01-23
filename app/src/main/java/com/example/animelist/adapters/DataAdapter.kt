package com.example.animelist.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.animelist.AnimeListener
import com.example.animelist.R
import com.example.animelist.databinding.ItemLayoutBinding
import com.example.animelist.model.Anime
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class AnimeListAdapter(var animeList: MutableList<Anime>, var favList: MutableLiveData<MutableList<Anime>?>, val listener: AnimeListener): RecyclerView.Adapter<AnimeListAdapter.ViewHolder>(){
    inner class ViewHolder(view: View): RecyclerView.ViewHolder(view){
        val binding = ItemLayoutBinding.bind(view)
        fun setListener(anime:Anime) {
            binding.root.setOnClickListener {
                println("Adapter Clicked <-----")
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
        return animeList.size
    }
    override fun onBindViewHolder(holder: ViewHolder, position:Int) {
        val anime = animeList[position]
        with(holder){
            setListener(anime)
            binding.animeName.text = anime.title
            setFavIcon(anime, binding)
            binding.addOrRemoveToFav.setOnClickListener {
                if (!anime.isFav) {
                    addToFav(anime)
                    setFavIcon(anime, binding)
                } else {
                    removeFromFav(anime)
                    setFavIcon(anime, binding)
                }
            }
            Glide.with(context)
                .load(anime.images.webp.smallImageUrl)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .centerCrop()
                .circleCrop()
                .into(binding.animeImage)
               }
    }
    private fun addToFav(anime: Anime) {
        anime.isFav = true
        if (favList.value == null) {
            favList.value = mutableListOf()
        }
        favList.value!!.add(anime)
        favList.postValue(favList.value)
    }
    private fun removeFromFav(anime: Anime) {
        anime.isFav = false
        favList.value!!.remove(anime)
        favList.postValue(favList.value)
    }
    private fun setFavIcon(anime: Anime, binding: ItemLayoutBinding ) {
        if (anime.isFav) {
            binding.addOrRemoveToFav.setImageResource(R.drawable.active_fav_icon)
        } else {
            binding.addOrRemoveToFav.setImageResource(R.drawable.inactive_fav_icon)
        }
    }

    suspend fun updateDataBase(anime: Anime){
        withContext(Dispatchers.IO) {
//            AnimeListApplication.animeDataBase.animeDao().updateAnime(anime)
        }
    }
}