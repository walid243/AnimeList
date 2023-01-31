package com.example.animelist.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.animelist.AnimeListApplication
import com.example.animelist.AnimeListener
import com.example.animelist.R
import com.example.animelist.databinding.ItemLayoutBinding
import com.example.animelist.model.Anime
import com.example.animelist.model.AnimeEntity
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
                    withContext(Dispatchers.IO) {
                        addToFav(anime)
                    }
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
    private suspend fun addToFav(anime: Anime) {
        anime.isFav = true
        InsertToDataBase(anime)
        if (favList.value == null) {
            favList.value = mutableListOf()
        }
        favList.value!!.add(anime)
        favList.postValue(favList.value)
    }
    private suspend fun removeFromFav(anime: Anime) {
        anime.isFav = false
        DeleteFromDataBase(anime)
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

    suspend fun InsertToDataBase(anime: Anime){
        val animeEntity = AnimeEntity(
            malId = anime.malId,
            title = anime.title,
            episodes = anime.episodes,
            isFav = anime.isFav,
            synopsis = anime.synopsis,
            type = anime.type,
            url = anime.url,
            year = anime.year,
            status = anime.status,
        )
        withContext(Dispatchers.IO) {
            AnimeListApplication.animeDataBase.animeDao().addAnime(animeEntity)
        }
    }
    suspend fun DeleteFromDataBase(anime: Anime){
        val animeEntity = AnimeEntity(
            malId = anime.malId,
            title = anime.title,
            episodes = anime.episodes,
            isFav = anime.isFav,
            synopsis = anime.synopsis,
            type = anime.type,
            url = anime.url,
            year = anime.year,
            status = anime.status,
        )
        withContext(Dispatchers.IO) {
            AnimeListApplication.animeDataBase.animeDao().deleteAnime(animeEntity)
        }
    }
}