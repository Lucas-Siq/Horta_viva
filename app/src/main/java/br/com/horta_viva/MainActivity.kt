package br.com.horta_viva

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.fragment.app.Fragment
import br.com.horta_viva.fragments.Empresa
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide();
        setContentView(R.layout.activity_main)

        val button: Button = findViewById<androidx.appcompat.widget.AppCompatButton>(R.id.button)

        button.setOnClickListener{
            val i = Intent(this, loginColaborador::class.java)
            startActivity(i)
        }


    }

}