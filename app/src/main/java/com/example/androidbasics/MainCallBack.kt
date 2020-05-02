package com.example.androidbasics

interface MainCallBack {
    fun onSuccess(res: String){}
    fun onFailure(err: String){}
}