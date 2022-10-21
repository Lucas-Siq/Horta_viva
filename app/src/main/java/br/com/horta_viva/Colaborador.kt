package br.com.horta_viva

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Colaborador : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide();
        setContentView(R.layout.activity_colaborador)

        val back: Button = findViewById<androidx.appcompat.widget.AppCompatButton>(R.id.back)

        back.setOnClickListener{
            val i = Intent(this, home::class.java)
            startActivity(i)
        }

    }
}