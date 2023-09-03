package com.example.project_s_h_o_p

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class AuthActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth)
        val login: EditText = findViewById(R.id.user_login_auth)
        val password: EditText = findViewById(R.id.user_password_auth)
        val button: Button = findViewById(R.id.button_auth)

        val linkToReg: TextView = findViewById(R.id.registration_text)
        linkToReg.setOnClickListener() {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        button.setOnClickListener() {
            val logintext = login.text.toString().trim()
            val passwordtext = password.text.toString().trim()

            if (logintext.isEmpty() || passwordtext.isEmpty()) {
                Toast.makeText(this, "Provide all fields", Toast.LENGTH_LONG).show()
            } else {
                val db = DbHelper(this, null)
                val isAuth = db.getUser(logintext, passwordtext) //dodajemy usera do bazy danych

                if (isAuth) {
                    Toast.makeText(this, "Done! Hello $logintext", Toast.LENGTH_SHORT).show()
                    login.text.clear()
                    password.text.clear()
                } else {
                    Toast.makeText(this, "Ups! U can't Auth", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}