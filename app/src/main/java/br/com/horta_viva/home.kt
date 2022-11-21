package br.com.horta_viva

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton
import br.com.horta_viva.databinding.ActivityHomeBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.ktx.Firebase

class home : AppCompatActivity() {

    private lateinit var binding:ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide();
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Logout
        binding.buttonLogout.setOnClickListener {
            FirebaseAuth.getInstance().signOut()
            val voltarTelaLogin = Intent(this, loginColaborador::class.java)
            startActivity(voltarTelaLogin)
            finish()
        }

        //botão perfil
        val buttonPerfil: TextView =
            findViewById<TextView>(R.id.icon_perfil)

        buttonPerfil.setOnClickListener {
            val i = Intent(this, Colaborador::class.java)
            startActivity(i)

        }

        //botão Agendamento
        val buttonAgendamento: TextView =
            findViewById<TextView>(R.id.icon_agendamentos)

        buttonAgendamento.setOnClickListener {
            val i = Intent(this, agendamento::class.java)
            startActivity(i)

        }

        //botão Loja
        val buttonLoja: TextView =
            findViewById<TextView>(R.id.icon_loja)

        buttonLoja.setOnClickListener {
            val i = Intent(this, loja::class.java)
            startActivity(i)

        }

        //loja
        val buttonquero1: AppCompatButton = findViewById<AppCompatButton>(R.id.button_compra_home1)

        buttonquero1.setOnClickListener {
            val i = Intent(this, loja::class.java)
            startActivity(i)
        }

        val buttonquero2: AppCompatButton = findViewById<AppCompatButton>(R.id.button_compra_home2)

        buttonquero2.setOnClickListener {
            val i = Intent(this, loja::class.java)
            startActivity(i)
        }

        val buttonquero3: AppCompatButton = findViewById<AppCompatButton>(R.id.button_compra_home3)

        buttonquero3.setOnClickListener {
            val i = Intent(this, loja::class.java)
            startActivity(i)
        }
    }

}