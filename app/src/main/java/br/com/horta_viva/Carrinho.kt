package br.com.horta_viva

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import br.com.horta_viva.databinding.ActivityCarrinhoBinding
import kotlinx.datetime.*

class Carrinho : AppCompatActivity() {

    private lateinit var binding: ActivityCarrinhoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide();
        binding = ActivityCarrinhoBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}

