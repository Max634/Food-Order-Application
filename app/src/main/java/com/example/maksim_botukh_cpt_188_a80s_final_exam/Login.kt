package com.example.maksim_botukh_cpt_188_a80s_final_exam

import android.annotation.SuppressLint
import android.content.ContentValues.TAG
import android.content.Intent
import android.os.Bundle
import android.provider.ContactsContract
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import com.example.maksim_botukh_cpt_188_a80s_final_exam.Login_Signup.Companion.Email
import com.example.maksim_botukh_cpt_188_a80s_final_exam.Login_Signup.Companion.Password
import com.google.firebase.auth.FirebaseAuth


class Login : AppCompatActivity() {
    lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val actionBar: ActionBar? = supportActionBar
        actionBar?.hide()

        val login_email = findViewById<EditText>(R.id.et_login_email)
        val login_password = findViewById<EditText>(R.id.et_login_password)
        val login_account = findViewById<TextView>(R.id.tv_login_notAcc)
        val login_button = findViewById<Button>(R.id.btn_login)
        val forgot_password = findViewById<TextView>(R.id.tv_for_pass)

        forgot_password.setOnClickListener {
            Intent(this, Signup::class.java).apply { startActivity(this) }
        }

        login_account.setOnClickListener {
            Intent(this, Signup::class.java).apply { startActivity(this) }
        }

        login_button.setOnClickListener {
            val Email_login = login_email.text.toString()
            val Password_login = login_password.text.toString()


            val emailpattern = "[a-zA-Z0-9._-]+@['a-z']+\\.+['a-z']+"
            if (Email_login.isEmpty() || Email_login.isNotEmpty()) {
                if (Email_login.isEmpty()) {
                    login_email.error = "Email Required"
                } else if (Email_login.matches(emailpattern.toRegex())) {
                    if (Password_login.isEmpty()) {
                        login_password.error = "Valid Password Required"
                    } else {
                        if (Email_login == Email && Password_login == Password) {
                            Intent(this, MainActivity::class.java).apply { startActivity(this) }
                        } else {
                            Toast.makeText(
                                applicationContext,
                                "Enter valid email or password",
                                Toast.LENGTH_LONG
                            ).show()
                        }
                    }
                } else {
                    login_email.error = "Valid Email Required"
                }
            }
        }
    }
}

