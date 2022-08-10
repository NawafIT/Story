package com.example.story

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class Addstory : AppCompatActivity() {

    private var title: EditText? = null
    private var subtitle: EditText? = null
    private var desc: EditText? = null
    private var Buttonaddstory: Button? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_addstory)

        connectViews()
        fieldsValid()




    }

    private fun connectViews(){
        title = findViewById(R.id.addTitle)
        subtitle = findViewById(R.id.addSubTitle)
        desc = findViewById(R.id.writeStory)
        Buttonaddstory = findViewById(R.id.addStory)
    }
    private fun fieldsValid(){
        Buttonaddstory?.setOnClickListener {
            if(title!!.text.isEmpty()){
                title?.error = "اكتب العنوان"
            }else if(subtitle!!.text.isEmpty()){
                subtitle?.error = "اكتب العنوان الفرعي"
            }else if(desc!!.text.isEmpty()){
                desc?.error = "اكتب القصة"
            }else{
                finish()
                addStory()
            }
        }
    }
    private fun addStory(){

            val i: Intent = Intent(this, MainActivity::class.java)
            i.putExtra("titleStory",title!!.text.toString())
            i.putExtra("subtitleStory",subtitle!!.text.toString())
            i.putExtra("descStory",desc!!.text.toString())
            startActivity(i)

    }
}