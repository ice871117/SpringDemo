package com.example.springdemo.model

import com.fasterxml.jackson.annotation.JsonFormat
import com.fasterxml.jackson.annotation.JsonInclude
import java.util.Date

data class Article(var id: Long=-1, var author: String="", var title: String="", var content: String="",
                   @JsonInclude(JsonInclude.Include.NON_NULL)
                   @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
                   var createTime: Date = Date()) {
}