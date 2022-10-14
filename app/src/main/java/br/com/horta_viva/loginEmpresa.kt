package br.com.horta_viva

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import br.com.horta_viva.fragments.Empresa

class loginEmpresa : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide();
        setContentView(R.layout.activity_login_empresa)

        val button6: Button = findViewById<androidx.appcompat.widget.AppCompatButton>(R.id.button6)

        button6.setOnClickListener {
            val i = Intent(this, Empresa::class.java)
            startActivity(i)
        }
    }
}