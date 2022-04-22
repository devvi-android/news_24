package com.example.news_24.app.ui

import androidx.lifecycle.ViewModel
import com.example.news_24.app.repository.NewsRepository

class NewsViewModel(
    val newsRepository : NewsRepository
) : ViewModel() {
}