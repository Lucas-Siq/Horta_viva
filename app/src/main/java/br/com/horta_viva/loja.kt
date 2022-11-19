package br.com.horta_viva

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.widget.AppCompatButton
import br.com.horta_viva.databinding.ActivityCarrinhoBinding
import br.com.horta_viva.databinding.ActivityColaboradorBinding
import br.com.horta_viva.databinding.ActivityLojaBinding
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.snackbar.Snackbar

class loja : AppCompatActivity() {

    private lateinit var binding: ActivityLojaBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide();
        binding = ActivityLojaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val back: Button = findViewById<AppCompatButton>(R.id.back)

        back.setOnClickListener {
            val i = Intent(this, home::class.java)
            startActivity(i)
            finish()
        }

        binding.buttonIncluirCarrinho.setOnClickListener { showModalDialog() }

    }

    private fun showModalDialog() {
        val dialog = BottomSheetDialog(this, R.style.BottomSheetDialog)

        val sheetBinding: ActivityCarrinhoBinding =
            ActivityCarrinhoBinding.inflate(layoutInflater, null, false)

        dialog.setContentView(sheetBinding.root)
        dialog.show()
    }


    fun onRadioButtonClicked(view: View) {
        if (view is RadioButton) {
            val checked = view.isChecked

            when (view.getId()) {
                R.id.radio_button_individual ->
                    if (checked) {
                        binding.textRadioButtonTipoCestaSelected.text = "Cesta Individual"
                        binding.valueRadioButtonTipoCestaSelected.text = "R$39,00"
                        binding.valueFrete.text = "Frete R$10,00"
                        binding.valuePedidoUnitario.text = "R$49,00"

                        var snackbar =
                            Snackbar.make(view, "Cesta Individual escolhida", Snackbar.LENGTH_SHORT)
                        snackbar.setBackgroundTint(Color.GREEN)
                        snackbar.setTextColor(Color.DKGRAY)
                        snackbar.show()
                    }
                R.id.radio_button_casal ->
                    if (checked) {
                        binding.textRadioButtonTipoCestaSelected.text = "Cesta Casal"
                        binding.valueRadioButtonTipoCestaSelected.text = "R$59,00"
                        binding.valueFrete.text = "Frete R$12,50"
                        binding.valuePedidoUnitario.text = "R$71,50"

                        var snackbar =
                            Snackbar.make(view, "Cesta Casal escolhida", Snackbar.LENGTH_SHORT)
                        snackbar.setBackgroundTint(Color.GREEN)
                        snackbar.setTextColor(Color.DKGRAY)
                        snackbar.show()
                    }
                R.id.radio_button_familia ->
                    if (checked) {
                        binding.textRadioButtonTipoCestaSelected.text = "Cesta Família"
                        binding.valueRadioButtonTipoCestaSelected.text = "R$79,00"
                        binding.valueFrete.text = "Frete R$15,00"
                        binding.valuePedidoUnitario.text = "R$94,00"

                        var snackbar =
                            Snackbar.make(view, "Cesta Família escolhida", Snackbar.LENGTH_SHORT)
                        snackbar.setBackgroundTint(Color.GREEN)
                        snackbar.setTextColor(Color.DKGRAY)
                        snackbar.show()
                    }
                R.id.radio_button_frutas ->
                    if (checked) {
                        binding.textRadioButtonTipoItensSelected.text = "Frutas"

                        var snackbar =
                            Snackbar.make(view, "Tipo de itens: Frutas", Snackbar.LENGTH_SHORT)
                        snackbar.setBackgroundTint(Color.GREEN)
                        snackbar.setTextColor(Color.DKGRAY)
                        snackbar.show()
                    }
                R.id.radio_button_legumes ->
                    if (checked) {
                        binding.textRadioButtonTipoItensSelected.text = "Legumes"

                        var snackbar =
                            Snackbar.make(view, "Tipo de itens: Legumes", Snackbar.LENGTH_SHORT)
                        snackbar.setBackgroundTint(Color.GREEN)
                        snackbar.setTextColor(Color.DKGRAY)
                        snackbar.show()
                    }
                R.id.radio_button_mista ->
                    if (checked) {
                        binding.textRadioButtonTipoItensSelected.text = "Mista"

                        var snackbar =
                            Snackbar.make(view, "Tipo de itens: Misto", Snackbar.LENGTH_SHORT)
                        snackbar.setBackgroundTint(Color.GREEN)
                        snackbar.setTextColor(Color.DKGRAY)
                        snackbar.show()
                    }
            }
        }
    }
}