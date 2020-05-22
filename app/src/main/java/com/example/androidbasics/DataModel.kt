package com.example.androidbasics

class DataModel {
    var status = ""
    var totalResults = 0

    lateinit var articles: MutableList<Articles>

    class Articles{
        var author = ""
        var title = ""
        var description = ""
        var url = ""
        var urlToImage = ""
        var publishedAt = ""
        var content = ""
    }

//    class sourceData {
//        var id = ""
//        var name=""
//    }

}