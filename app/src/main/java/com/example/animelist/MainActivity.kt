package com.example.animelist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.animelist.databinding.ActivityMainBinding
import com.example.animelist.fragments.AnimeList

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportFragmentManager.beginTransaction().apply {
            replace(binding.fragmentContainerView.id, AnimeList())
            commit()
        }
    }
}