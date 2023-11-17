package com.example.springdemo.controller

import com.example.springdemo.model.Article
import com.example.springdemo.base.AjaxResponse
import com.example.springdemo.service.ArticleJDBCService
import com.example.springdemo.service.ArticleService
import jakarta.annotation.Resource
import org.slf4j.Logger
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
class ArticleController {

    //create a logger from slf4j
    val logger: Logger = org.slf4j.LoggerFactory.getLogger(ArticleController::class.java)

    @Resource
    val service: ArticleService? = null

    @GetMapping("/article")
    fun getArticles(): AjaxResponse {
        val results = service?.getAll()
        logger.info("get all articles: {}", results)
        return AjaxResponse.createSuccessResponse(results)
    }

    @GetMapping("/article/{id}")
    fun getArticle(@PathVariable id: Long?): AjaxResponse {
        val article = service?.getArticle(id)
        logger.info("get article: {}", article)
        return AjaxResponse.createSuccessResponse(article)
    }

    @PostMapping("/article")
    fun createArticle(@RequestBody article: Article?): AjaxResponse {
        service?.saveArticle(article.also { it?.createTime = Date()  })
        logger.info("create article: {}", article)
        return AjaxResponse.createSuccessResponse(null)
    }

    @DeleteMapping("/article/{id}")
    fun deleteArticle(@PathVariable id: Long?): AjaxResponse {
        service?.deleteArticle(id)
        logger.info("delete article: {}", id)
        return AjaxResponse.createSuccessResponse(null)
    }

    @PutMapping("/article")
    fun updateArticle(@RequestBody article: Article?): AjaxResponse {
        service?.updateArticle(article)
        logger.info("update article: {}", article)
        return AjaxResponse.createSuccessResponse(null)
    }
}