package com.example.story

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.widget.TextView
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import kotlin.system.exitProcess

class MainActivity : AppCompatActivity() {

    private var drawer: DrawerLayout? = null
    private var tool: Toolbar? = null
    private var nav: NavigationView? = null
    private var welcome: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        connectView()
        val i: Intent = intent
        setSupportActionBar(tool!!)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        changeNameOnHeader(i.getStringExtra("name").toString())
        startUp()
        drawerClicks()

    }

    private fun connectView(){
        drawer = findViewById(R.id.drawer)
        tool = findViewById(R.id.bar)
        nav = findViewById(R.id.navView)

    }
    private fun startUp(){
        val action: ActionBarDrawerToggle = ActionBarDrawerToggle(this, drawer!! ,R.string.open, R.string.close)
        drawer?.addDrawerListener(action)
        action.syncState()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            android.R.id.home -> {
                drawer?.openDrawer(GravityCompat.START)
                true
            }
            else -> true
        }
    }

    private fun changeNameOnHeader(name:String){
        val header = nav?.getHeaderView(0)
        welcome  = header?.findViewById(R.id.welcome)
        welcome?.text = "اهلًا يا $name"
    }

    private fun drawerClicks(){
         nav?.setNavigationItemSelectedListener {
            when(it.itemId){
                R.id.Home2 -> {
                    drawer?.closeDrawer(GravityCompat.START)
                    true
                }
                R.id.logout2 -> {
                    finish()
                    val i: Intent = Intent(this, Login::class.java)
                    startActivity(i)
                    true

                }
                else -> true
            }
        }
    }
}