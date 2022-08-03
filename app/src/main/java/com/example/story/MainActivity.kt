package com.example.story

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val i: Intent = intent
        Log.i("Name",i.getStringExtra("name").toString())
        Log.i("pass",i.getStringExtra("password").toString())
    }
}