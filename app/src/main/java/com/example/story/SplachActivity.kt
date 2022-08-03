package com.example.story

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper

class SplachActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splach)
        moveToAnotherActivity()
    }

    private fun moveToAnotherActivity(){
        // هذا الكود يقوم بتأخير الانتقال من واجهة الى واجهة اخرى
        Handler(Looper.myLooper()!!).postDelayed({
            finish() // هذه الدالة تستخدم لحذف واجهة التحميل بعد ان تظهر لمرة واحدة
            val i: Intent = Intent(this,Login::class.java)
            startActivity(i)
        } ,2400)

    }
}