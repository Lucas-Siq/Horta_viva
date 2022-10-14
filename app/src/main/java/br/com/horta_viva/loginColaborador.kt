package br.com.horta_viva

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class loginColaborador : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide();
        setContentView(R.layout.activity_login_colaborador)

        val button5: Button = findViewById<androidx.appcompat.widget.AppCompatButton>(R.id.button5)

        button5.setOnClickListener{
            val i = Intent(this, Colaborador::class.java)
            startActivity(i)
        }
    }
}