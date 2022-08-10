package com.example.story

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.widget.Toolbar

class StoryDetalis : AppCompatActivity() {

    private var tool : Toolbar?= null
    private var text:TextView? =null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_story_detalis)

        connectViews()

        setSupportActionBar(tool!!)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)


        val titles = intent.getStringExtra("title")
        val desc = intent.getStringExtra("description")
        supportActionBar?.title = titles
        text?.text = desc
        tool?.setNavigationOnClickListener {
            onBackPressed()
        }


    }
    private fun connectViews(){
        tool = findViewById(R.id.toolbar2)
        text = findViewById(R.id.text22)
    }
}