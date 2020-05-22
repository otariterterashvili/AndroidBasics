package com.example.androidbasics

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.gson.Gson
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var isLoading = true

    private val resDataList = ArrayList<DataModel.Articles>()
    private lateinit var adapter: RecyclerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }

    private fun init(){
        mainRecyclerView.layoutManager = LinearLayoutManager(this)

        adapter = RecyclerAdapter(resDataList)
        mainRecyclerView.adapter = adapter

        DataLoader.getRequest(object: MainCallBack{
            override fun onSuccess(res: String) {
                Log.d("resObject", res)

                val model = Gson().fromJson(res, DataModel::class.java)
                for (i in model.articles){
                    resDataList.add(i)
                }

                adapter.notifyDataSetChanged()
            }
        })
    }
}
