package com.example.springdemo.dao

import com.example.springdemo.model.Article
import jakarta.annotation.Resource
import org.springframework.jdbc.core.BeanPropertyRowMapper
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.stereotype.Repository


@Repository
class ArticleJDBCDAO {

    @Resource
    var jdbcTemplate: JdbcTemplate? = null

    fun save(article: Article) {
        val sql = "insert into article(author, title, content, create_time) values(?, ?, ?, ?)"
        jdbcTemplate?.update(sql, article.author, article.title, article.content, article.createTime)
    }

    fun deleteById(id: Long) {
        val sql = "delete from article where id = ?"
        jdbcTemplate?.update(sql, id)
    }

    fun updateById(article: Article) {
        if (article.author.isNotEmpty() && article.title.isNotEmpty() && article.content.isNotEmpty()) {
            val sql = "update article set author = ?, title = ?, content = ? where id = ?"
            jdbcTemplate?.update(sql, article.author, article.title, article.content, article.id)
        }
        if (article.author.isNotEmpty() && article.title.isNotEmpty()) {
            val sql = "update article set author = ?, title = ? where id = ?"
            jdbcTemplate?.update(sql, article.author, article.title, article.id)
        }
        if(article.author.isNotEmpty()) {
            val sql = "update article set author = ? where id = ?"
            jdbcTemplate?.update(sql, article.author, article.id)
        }
        if(article.title.isNotEmpty()) {
            val sql = "update article set title = ? where id = ?"
            jdbcTemplate?.update(sql, article.title, article.id)
        }
        if(article.title.isNotEmpty() && article.content.isNotEmpty()) {
            val sql = "update article set title = ?, content = ? where id = ?"
            jdbcTemplate?.update(sql, article.title, article.content, article.id)
        }
        if(article.content.isNotEmpty()) {
            val sql = "update article set content = ? where id = ?"
            jdbcTemplate?.update(sql, article.content, article.id)
        }
    }

    fun findById(id: Long): Article? {
        val sql = "select * from article where id = ?"
        return jdbcTemplate?.queryForObject(sql, Article::class.java, id)
    }

    fun findAll(): List<Article?>? {
        val sql = "select * from article"
        return jdbcTemplate?.query(sql, BeanPropertyRowMapper(Article::class.java))
    }
}