package com.example.story

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class Login : AppCompatActivity() {

    private var user: EditText? = null
    private var pass: EditText? = null
    private var login: Button? = null
    private var check: CheckBox? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        connectViews()
        checkInputs()
    }

    private fun connectViews (){
        user = findViewById(R.id.name)
        pass = findViewById(R.id.pass)
        login = findViewById(R.id.button)
        check = findViewById(R.id.check)

    }

    private fun loginState(){

        val array: ArrayList<User> = ArrayList()
        array.add(User("Nawaf","nawaf21"))
        array.add(User("Yasser","3222"))
        array.add(User("majed","mm22"))


            val name: String = user?.text.toString()
            val password : String = pass?.text.toString()
            val users: User = User(name,password)
            for (i in array){
                if(users.name == i.name && users.pass == i.pass && check!!.isChecked){
                    Toast.makeText(this, "اهلا ${users.name}" , Toast.LENGTH_SHORT).show()
                    finish()
                    val i: Intent = Intent(this, MainActivity::class.java)
                    i.putExtra("name" , users.name)
                    startActivity(i)
                    break
                }else{
                    Toast.makeText(this, "تأكد من المعلومات المدخلة" , Toast.LENGTH_SHORT).show()

                }
            }


    }

    private fun checkInputs(){
        login?.setOnClickListener {
            if(user!!.text.isEmpty()){
                user?.error = "ادخل اسم المستخدم"
            }
            else if(pass!!.text.isEmpty() ){
                pass?.error = "ادخل كلمة المرور"
            }else{
                loginState()
            }
        }
    }

}