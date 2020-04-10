package com.example.androidbasics

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_add_item.*

class AddItemActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_item)
        init()
    }

    private fun init(){

        saveItemButton.setOnClickListener {
            returnMainActivity()
        }
    }

    private fun returnMainActivity(){
        val intent = intent

        val title = itemTitleEditText.text.toString()
        val desc = itemDescriptionEditText.text.toString()
        val createDate = itemDateEditText.text.toString()

        intent.putExtra("title", title)
        intent.putExtra("description", desc)
        intent.putExtra("createDate", createDate)

        setResult(Activity.RESULT_OK, intent)
        finish()
    }
}
