package com.example.springdemo.service

import com.example.springdemo.model.Article




interface ArticleService {
    fun saveArticle(article: Article?)

    fun deleteArticle(id: Long?)

    fun updateArticle(article: Article?)

    fun getArticle(id: Long?): Article?

    fun getAll(): List<Article?>?
}