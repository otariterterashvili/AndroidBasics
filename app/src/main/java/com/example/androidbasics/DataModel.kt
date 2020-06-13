package com.example.androidbasics

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class DataModel {
    var descriptionKA = ""
    var titleKA = ""
    var cover = ""
    var category = ""
}
class CollectionData: ViewModel() {
    private val arrayList: ArrayList<DataModel> = ArrayList()
}