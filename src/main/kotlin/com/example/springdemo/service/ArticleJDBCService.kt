package com.example.springdemo.service

import com.example.springdemo.dao.ArticleJDBCDAO
import com.example.springdemo.model.Article
import jakarta.annotation.Resource
import org.springframework.stereotype.Service

@Service
class ArticleJDBCService: ArticleService {

    //import logger by lf4j
    private val logger = org.slf4j.LoggerFactory.getLogger(ArticleJDBCService::class.java)

    @Resource
    var articleJDBCDAO: ArticleJDBCDAO? = null

    override fun saveArticle(article: Article?) {
        if (article == null) {
            logger.info("saveArticle article is null")
            return
        }
        articleJDBCDAO?.save(article)
    }

    override fun deleteArticle(id: Long?) {
        if (id == null) {
            logger.info("deleteArticle id is null")
            return
        }
        articleJDBCDAO?.deleteById(id)
    }

    override fun updateArticle(article: Article?) {
        if (article == null) {
            logger.info("updateArticle article is null")
            return
        }
        articleJDBCDAO?.updateById(article)
    }

    override fun getArticle(id: Long?): Article? {
        if (id == null) {
            logger.info("getArticle id is null")
            return null
        }
        return articleJDBCDAO?.findById(id)
    }

    override fun getAll(): List<Article?>? {
        return articleJDBCDAO?.findAll()
    }
}