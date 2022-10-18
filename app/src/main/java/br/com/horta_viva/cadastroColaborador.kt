package br.com.horta_viva

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class cadastroColaborador : AppCompatActivity() {

    private lateinit var textView: TextView
    private lateinit var imageView: ImageView

    companion object {
        val IMAGE_REQUEST_CODE = 100
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide();
        setContentView(R.layout.activity_cadastro_colaborador)


        val backLogin: Button = findViewById<androidx.appcompat.widget.AppCompatButton>(R.id.backLogin)

        backLogin.setOnClickListener{
            val i = Intent(this, loginColaborador::class.java)
            startActivity(i)
        }

        textView = findViewById(R.id.button_pick_image)
        imageView = findViewById(R.id.img_selected_photo)

        textView.setOnClickListener{
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