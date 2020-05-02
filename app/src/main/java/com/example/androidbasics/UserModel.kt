package com.example.androidbasics

import com.google.gson.annotations.SerializedName

class UserModel {
    var page = 0;
    @SerializedName("per_page")
    var perPage = 0
    var total = 0
    @SerializedName("total_page")
    var totalPage = 0
    lateinit var data: MutableList<Data>

    class Data{
        var id = 0
        var email = ""
        @SerializedName("first_name")
        var firstName = ""
        @SerializedName("last_name")
        var lastName = ""
        var avatar = ""
    }

}