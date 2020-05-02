package com.example.androidbasics

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log.d
import com.google.gson.Gson
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var isLoading = true

    private val resDataList = ArrayList<UserModel.Data>()
    private lateinit var adapter: RecyclerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }

    private fun init(){
        mainRecyclerView.layoutManager = LinearLayoutManager(this)

        adapter = RecyclerAdapter(resDataList, this)
        mainRecyclerView.adapter = adapter

        DataLoader.getRequest("users", object: MainCallBack{
            override fun onSuccess(res: String) {
                isLoading=false
                val model = Gson().fromJson(res, UserModel::class.java)
                d("count", "${model.data.size}")
                d("userEamil", "${model.data[0].email}")
                for (i in model.data){
                    resDataList.add(i)
                }

                adapter.notifyDataSetChanged()


            }
        })
    }
}
