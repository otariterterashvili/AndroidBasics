package com.example.androidbasics

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.androidbasics.databinding.ActivityMainBinding
import com.google.gson.Gson
import org.json.JSONArray



class MainActivity : AppCompatActivity() {
    private var mainList = ArrayList<DataModel>()
    lateinit var binding: ActivityMainBinding
    lateinit var viewModle : CollectionData

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.mainModel = viewModle
        init()
    }

    private fun init(){
        DataLoader.getRequest(object : MainCallBack{
            override fun onSuccess(res: String) {
                val model: List<DataModel> = Gson().fromJson(res, Array<DataModel>::class.java).toList()
                mainList = model.toCollection(ArrayList())
                Log.d("mainResponse", mainList[0].category)
//                Log.d("mainResponse", model[0].category)
            }
        })

    }
}
