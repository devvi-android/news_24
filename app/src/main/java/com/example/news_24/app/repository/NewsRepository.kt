package com.example.news_24.app.repository

import com.example.news_24.app.api.RetrofitInstance
import com.example.news_24.app.db.ArticleDatabase

class NewsRepository(
    val db: ArticleDatabase
) {

    suspend fun getBreakingNews(countryCode: String, pageNumber: Int) =
        RetrofitInstance.api.getBreakingNews(countryCode, pageNumber)
}