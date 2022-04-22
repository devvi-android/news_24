package com.example.news_24.app.models

data class NewsResponse(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)