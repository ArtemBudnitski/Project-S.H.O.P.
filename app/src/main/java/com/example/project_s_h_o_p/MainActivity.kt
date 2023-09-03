package com.example.project_s_h_o_p

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.project_s_h_o_p.ui.theme.Project_S_H_O_PTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val login: EditText = findViewById(R.id.user_login)
        val password: EditText = findViewById(R.id.user_password)
        val email =  findViewById<EditText>(R.id.user_mail)
        val button: Button = findViewById(R.id.button_reg)
        val linkToAuth: TextView = findViewById(R.id.log_in_text)


        linkToAuth.setOnClickListener{
            val intent = Intent(this, AuthActivity::class.java)
            startActivity(intent)
        }

        button.setOnClickListener(){
            val logintext = login.text.toString().trim()
            val passwordtext = password.text.toString().trim()
            val emailtext = email.text.toString().trim()

            if (logintext.isEmpty() || passwordtext.isEmpty() || emailtext.isEmpty()){
                Toast.makeText(this, "Provide all fields", Toast.LENGTH_SHORT).show()
            }else{
                val user = User(logintext, passwordtext, emailtext) //przekazuje dane do klasy User-konstruktora
                val db = DbHelper(this, null) //context this - odnosi sie do tej klasy, null - bo nie chcemy tworzyc bazy danych
                db.adduser(user) //dodajemy usera do bazy danych
                Toast.makeText(this, "Registered on the database! Welcome $login!", Toast.LENGTH_SHORT).show()

                login.text.clear()
                password.text.clear()
                email.text.clear()

            }
        }
        }
    }

