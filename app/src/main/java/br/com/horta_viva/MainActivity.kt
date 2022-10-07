package br.com.horta_viva

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide();
        setContentView(R.layout.activity_main)

        val button: Button = findViewById<androidx.appcompat.widget.AppCompatButton>(R.id.button)

        button.setOnClickListener{
            val i = Intent(this, Colaborador::class.java)
            startActivity(i)
        }

        val button2: Button = findViewById<androidx.appcompat.widget.AppCompatButton>(R.id.button2)

        button2.setOnClickListener{
            val i = Intent(this, Empresa::class.java)
            startActivity(i)
        }
    }

}