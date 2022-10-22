package br.com.horta_viva

import android.app.ProgressDialog.show
import android.content.Intent
import android.graphics.Color
import android.graphics.ColorSpace
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.CalendarContract
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.ColorRes
import br.com.horta_viva.databinding.ActivityCadastroColaboradorBinding
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.FirebaseNetworkException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException
import com.google.firebase.auth.FirebaseAuthUserCollisionException
import com.google.firebase.auth.FirebaseAuthWeakPasswordException
import com.google.firebase.firestore.FirebaseFirestore

class cadastroColaborador : AppCompatActivity() {

    private lateinit var textView: TextView
    private lateinit var imageView: ImageView
    private lateinit var binding: ActivityCadastroColaboradorBinding
    private val auth = FirebaseAuth.getInstance()
    private val db = FirebaseFirestore.getInstance()

    companion object {
        val IMAGE_REQUEST_CODE = 100
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide();
        binding = ActivityCadastroColaboradorBinding.inflate(layoutInflater)
        setContentView(binding.root)


//Botão Voltar
        val backLogin: Button =
            findViewById<androidx.appcompat.widget.AppCompatButton>(R.id.backLogin)

        backLogin.setOnClickListener {
            val i = Intent(this, loginColaborador::class.java)
            startActivity(i)
        }

//Validar cadastro
        binding.buttonSalvaralteracoesColaborador.setOnClickListener{ view ->
            val cpf = binding.edtCpfColaborador.text.toString()
            val nome = binding.edtNomeColaborador.text.toString()
            val email = binding.edtEmailCadastroColaborador.text.toString()
            val senha = binding.edtSenhaCadastroColaborador.text.toString()
            val confirmeSenha = binding.edtConfirmeSenhaCadastroColaborador.text.toString()
            val cargo = binding.edtCargoColaborador.text.toString()
            val cep = binding.edtCepColaborador.text.toString()
            val rua = binding.edtRuaColaborador.text.toString()
            val bairro = binding.edtBairroColaborador.text.toString()
            val numeroCasa = binding.edtNumerocasaColaborador.text.toString()
            val cidade = binding.edtCidadeColaborador.text.toString()
            val uf = binding.edtUfColaborador.text.toString()

            if (cpf.isEmpty() || nome.isEmpty() || email.isEmpty() || senha.isEmpty() || confirmeSenha.isEmpty() || cargo.isEmpty() || cep.isEmpty() ||
                rua.isEmpty() || bairro.isEmpty() || numeroCasa.isEmpty() || cidade.isEmpty() || uf.isEmpty()){
                val snackbarCadastro = Snackbar.make(view, "Preencha todos os campos!", Snackbar.LENGTH_SHORT)
                snackbarCadastro.setBackgroundTint(Color.RED)
                snackbarCadastro.show()
            }else if(senha != confirmeSenha){ val snackbarCadastro2 = Snackbar.make(view, "A Senha não confere!", Snackbar.LENGTH_SHORT)
                snackbarCadastro2.setBackgroundTint(Color.RED)
                snackbarCadastro2.show()
            }else {
                auth.createUserWithEmailAndPassword(email,senha).addOnCompleteListener {cadastro ->
                    if (cadastro.isSuccessful){
                        val usuariosMap = hashMapOf(
                            "cpf" to cpf,
                            "nomeCompleto" to nome,
                            "email" to email,
                            "senha" to senha,
                            "cargo" to cargo,
                            "cep" to cep,
                            "rua" to rua,
                            "bairro" to bairro,
                            "numeroCasa" to numeroCasa,
                            "cidade" to cidade,
                            "uf" to uf,
                        )

                        db.collection("Usuarios").document(email)
                            .set(usuariosMap).addOnCompleteListener {
                                Log.d("db","Sucesso ao salvar os dados do usuário!")
                            }.addOnFailureListener{

                            }


                        val snackbarCadastro = Snackbar.make(view, "Usuário Cadastrado!", Snackbar.LENGTH_SHORT)
                        snackbarCadastro.setBackgroundTint(Color.GREEN)
                        snackbarCadastro.show()
                        binding.edtCpfColaborador.setText("")
                        binding.edtNomeColaborador.setText("")
                        binding.edtEmailCadastroColaborador.setText("")
                        binding.edtSenhaCadastroColaborador.setText("")
                        binding.edtConfirmeSenhaCadastroColaborador.setText("")
                        binding.edtCargoColaborador.setText("")
                        binding.edtCepColaborador.setText("")
                        binding.edtRuaColaborador.setText("")
                        binding.edtBairroColaborador.setText("")
                        binding.edtNumerocasaColaborador.setText("")
                        binding.edtCidadeColaborador.setText("")
                        binding.edtUfColaborador.setText("")
                    }
                }.addOnFailureListener{ exception ->

                    val mensagemErro = when(exception){
                        is FirebaseAuthWeakPasswordException -> "Digite uma senha com no mínimo 6 caracteres!"
                        is FirebaseAuthInvalidCredentialsException -> "Digite um e-mail válido!"
                        is FirebaseAuthUserCollisionException -> "Esta conta já está cadastrada!"
                        is FirebaseNetworkException -> "Sem conexão com a Internet!"
                        else -> "Erro ao cadastrar usuário!"
                    }
                    val snackbarCadastro = Snackbar.make(view,mensagemErro, Snackbar.LENGTH_SHORT)
                    snackbarCadastro.setBackgroundTint(Color.RED)
                    snackbarCadastro.show()
                }
            }

        }

        //Escolher Imagem
        textView = findViewById(R.id.button_pick_image)
        imageView = findViewById(R.id.img_selected_photo)

        textView.setOnClickListener {
            pickImageGallery()
        }
    }

    private fun pickImageGallery() {
        val intent = Intent(Intent.ACTION_PICK)
        intent.type = "image/*"
        startActivityForResult(intent, IMAGE_REQUEST_CODE)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == IMAGE_REQUEST_CODE && resultCode == RESULT_OK) {
            imageView.setImageURI(data?.data)
        }
    }

}

