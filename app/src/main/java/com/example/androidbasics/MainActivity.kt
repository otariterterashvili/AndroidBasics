package com.example.androidbasics

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val mainList = ArrayList<Model>()
    private lateinit var adapter: RecyclerAdapter
    private val reqCode = 11

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        fillData()
        init()
    }

    private fun init(){

        addItemButton.setOnClickListener {
//            mainList.add(0, Model(R.mipmap.ic_launcher_round, title = "Lorem ???", description = "Ipsum dummy ???"))
//            adapter.notifyItemInserted(0)
//            mainRecyclerView.scrollToPosition(0)
            openAddItemActivity()

        }

        mainRecyclerView.layoutManager = LinearLayoutManager(this)

        adapter = RecyclerAdapter(mainList)

        mainRecyclerView.adapter = adapter
    }

    private fun fillData(){
        mainList.add(Model(R.mipmap.ic_launcher_round, title = "Lorem 1", description = "Ipsum dummy 1", createDate =  "04/04/2020"))
        mainList.add(Model(R.mipmap.ic_launcher_round, title = "Lorem 2", description = "Ipsum dummy 2", createDate =  "10/11/1999"))
        mainList.add(Model(R.mipmap.ic_launcher_round, title = "Lorem 3", description = "Ipsum dummy 3", createDate =  "04/04/2018"))
    }

    private fun openAddItemActivity(){
        val intent = Intent(this, AddItemActivity::class.java)
        startActivityForResult(intent, reqCode)

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if(resultCode == Activity.RESULT_OK && requestCode == reqCode){
            val titleData = data?.extras!!.getString("title", "")
            val descData = data.extras!!.getString("description", "")
            val createDateData = data.extras!!.getString("createDate", "")

            mainList.add(0, Model(R.mipmap.ic_launcher_round, title = titleData, description = descData, createDate = createDateData))
            adapter.notifyItemInserted(0)
            mainRecyclerView.scrollToPosition(0)
            adapter.notifyDataSetChanged()
        }
        super.onActivityResult(requestCode, resultCode, data)

    }
}
