package com.example.news_24.app

data class NewsResponse(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)