package br.com.horta_viva

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.lifecycle.whenStarted
import br.com.horta_viva.databinding.ActivityColaboradorBinding
import br.com.horta_viva.databinding.ActivityHomeBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

class Colaborador : AppCompatActivity() {

    private lateinit var binding: ActivityColaboradorBinding
    private val auth = FirebaseAuth.getInstance()
    private val db = FirebaseFirestore.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide();
        binding = ActivityColaboradorBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val back: Button = findViewById<androidx.appcompat.widget.AppCompatButton>(R.id.back)

        back.setOnClickListener{
            val i = Intent(this, home::class.java)
            startActivity(i)
            finish()
        }

    }

    override fun onResume() {
        super.onResume()
        val usuarioAtual = FirebaseAuth.getInstance().currentUser?.email

        db.collection("Usuarios").document(usuarioAtual.toString())
            .addSnapshotListener { documento, error ->
                if (documento != null) {
                    binding.txtNome.text = documento.getString("nomeCompleto")
                    binding.txtCargo.text = documento.getString("cargo")
                }
            }
    }


}

