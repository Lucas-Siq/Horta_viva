package br.com.horta_viva

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import br.com.horta_viva.databinding.ActivityLoginColaboradorBinding
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth

class loginColaborador : AppCompatActivity() {

    private lateinit var binding: ActivityLoginColaboradorBinding
    private val auth = FirebaseAuth.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide();
        binding = ActivityLoginColaboradorBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button5.setOnClickListener { view ->
            val email = binding.edtLoginColaborador.text.toString()
            val senha = binding.edtSenhaColaborador.text.toString()

            if (email.isEmpty() || senha.isEmpty()){
                var snackbar = Snackbar.make(view,"Preencha todos os campos",Snackbar.LENGTH_SHORT)
                snackbar.setBackgroundTint(Color.RED)
                snackbar.show()
            }else{
                auth.signInWithEmailAndPassword(email,senha).addOnCompleteListener{ autenticacao ->
                    if (autenticacao.isSuccessful){
                        navegarTelaPrincipal()
                    }
                }.addOnFailureListener{
                    var snackbar = Snackbar.make(view,"Erro ao fazer o login do Usuário",Snackbar.LENGTH_SHORT)
                    snackbar.setBackgroundTint(Color.RED)
                    snackbar.show()
                }
            }
        }

        val buttoncadastroColaborador: TextView = findViewById<TextView>(R.id.button_cadastro_colaborador)

        buttoncadastroColaborador.setOnClickListener{
            val i = Intent(this, cadastroColaborador::class.java)
            startActivity(i)
        }

    }
    private fun navegarTelaPrincipal(){
        val intent = Intent(this,home::class.java)
        startActivity(intent)
        finish()
    }
}