package com.example.animelist.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.MutableLiveData
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.animelist.AnimeListener
import com.example.animelist.R
import com.example.animelist.databinding.ItemLayoutBinding
import com.example.animelist.model.Anime


class FavAnimeAdapter(var favAnimeList: MutableLiveData<MutableList<Anime>?>, val listener: AnimeListener): androidx.recyclerview.widget.RecyclerView.Adapter<FavAnimeAdapter.FavAnimeViewHolder>()  {


    inner class FavAnimeViewHolder(view: View): androidx.recyclerview.widget.RecyclerView.ViewHolder(view) {
        val binding= ItemLayoutBinding.bind(itemView)
        fun setListener(anime:Anime) {
            binding.root.setOnClickListener {
                println("Adapter Clicked <-----")
                listener.onClick(anime)
            }
        }
    }
    private lateinit var context: Context
    
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavAnimeViewHolder {
        context = parent.context
        val view = LayoutInflater.from(context).inflate(R.layout.item_layout, parent, false)
        return FavAnimeViewHolder(view)
    }
    
    override fun getItemCount(): Int {
        return favAnimeList.value?.size ?: 0
    }
    
    override fun onBindViewHolder(holder: FavAnimeViewHolder, position: Int) {
        val anime = favAnimeList.value?.get(position)
        with(holder){
            if (anime != null) {
                setListener(anime)
                binding.animeName.text = anime.title
                setFavIcon(anime, binding)
                binding.addOrRemoveToFav.setOnClickListener {
                        removeFromFav(anime)
                        setFavIcon(anime, binding)
                }
//                Glide.with(context)
//                    .load(anime.images.webp.smallImageUrl)
//                    .diskCacheStrategy(DiskCacheStrategy.ALL)
//                    .centerCrop()
//                    .circleCrop()
//                    .into(binding.animeImage)
            }

        }
    }

    private fun removeFromFav(anime: Anime) {
        anime.isFav = false
        favAnimeList.value!!.remove(anime)
        favAnimeList.postValue(favAnimeList.value)
    }
    private fun setFavIcon(anime: Anime, binding: ItemLayoutBinding ) {
        if (anime.isFav) {
            binding.addOrRemoveToFav.setImageResource(R.drawable.active_fav_icon)
        } else {
            binding.addOrRemoveToFav.setImageResource(R.drawable.inactive_fav_icon)
        }
    }
}