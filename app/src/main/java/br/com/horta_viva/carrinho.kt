package br.com.horta_viva

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class carrinho : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide();
        setContentView(R.layout.activity_carrinho)
    }
}