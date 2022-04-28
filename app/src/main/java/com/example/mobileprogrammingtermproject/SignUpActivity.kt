package com.example.mobileprogrammingtermproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ScrollView
import android.widget.Toast
import android.widget.ViewAnimator
import com.example.mobileprogrammingtermproject.databinding.ActivitySignUpBinding
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_sign_up.*


class SignUpActivity : AppCompatActivity() {
    lateinit var binding:ActivitySignUpBinding
    val context = this
    var db = DatabaseHelper(context)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)


    }


    fun save(view: View){
        var name = editText_name.text.toString()
        var username = editText_username2.text.toString()
        var email = editText_email.text.toString()
        var password = editText_password2.text.toString()
        var confirmPassword = editText_confirmPassword.text.toString()

        if (name.isNotEmpty()&&username.isNotEmpty()&&email.isNotEmpty()
            &&password.isNotEmpty()){
            if (!password.equals(confirmPassword)){
                Toast.makeText(context,"Passwords must match!",Toast.LENGTH_LONG).show()
            }else{
                var user = User(username, name, email, password)
                db.insertData(user)
                startActivity(Intent(this@SignUpActivity,LoginActivity::class.java))
                finish()
            }
        }else{
            Toast.makeText(context,"Fill in the blanks!",Toast.LENGTH_LONG).show()
        }


    }

}

