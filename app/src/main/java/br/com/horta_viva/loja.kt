package br.com.horta_viva

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class loja : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide();
        setContentView(R.layout.activity_loja)
    }
}