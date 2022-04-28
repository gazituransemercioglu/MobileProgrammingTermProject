package com.example.mobileprogrammingtermproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.mobileprogrammingtermproject.databinding.ActivityLoginBinding
import com.example.mobileprogrammingtermproject.databinding.ActivitySignUpBinding
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {
    lateinit var binding: ActivityLoginBinding

    val context = this
    var db = DatabaseHelper(context)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
    fun login(view : View){

        var username = editText_username.text.toString()
        var password = editText_password.text.toString()
        var check = false
        if (username.isEmpty()||password.isEmpty()){
            Toast.makeText(context,"Fill in the blanks!",Toast.LENGTH_SHORT).show()
        }else{
            var data = db.readData()
            first@ for (i in 0 until data.size){

                if (data[i].username.equals(username)){
                    if (data[i].password.equals(password)){
                        val intent = Intent(this@LoginActivity,MainActivity::class.java)
                        startActivity(intent)
                        finish()
                        check = false
                        break@first
                    }else{
                        check = true
                    }
                }else{
                    check = true
                }
            }
            if (check){
                Toast.makeText(this,"Incorrect username or password!",Toast.LENGTH_SHORT).show()
            }

        }


    }
    fun signUp(view: View){
        val intent = Intent(this@LoginActivity,SignUpActivity::class.java)
        startActivity(intent)
    }
}