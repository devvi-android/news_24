package com.example.news_24.app.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.news_24.R
import com.example.news_24.app.db.ArticleDatabase
import com.example.news_24.app.repository.NewsRepository
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    lateinit var bottomNavigationView: BottomNavigationView
    lateinit var viewModel: NewsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val newsRepository = NewsRepository(ArticleDatabase(this))
        val viewModelProviderFactory = NewsViewModelProviderFactory(newsRepository)
        viewModel = ViewModelProvider(this,viewModelProviderFactory)[NewsViewModel::class.java]

        bottomNavigationView = findViewById(R.id.navigation_view)
        val navHostFragment= supportFragmentManager.findFragmentById(R.id.fragment_container) as NavHostFragment
        val navController= navHostFragment.navController
        bottomNavigationView.setupWithNavController(navController)
    }
}