package br.com.horta_viva

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

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

        val buttoncadastroColaborador: TextView = findViewById<TextView>(R.id.button_cadastro_colaborador)

        buttoncadastroColaborador.setOnClickListener{
            val i = Intent(this, cadastroColaborador::class.java)
            startActivity(i)
        }

    }
}