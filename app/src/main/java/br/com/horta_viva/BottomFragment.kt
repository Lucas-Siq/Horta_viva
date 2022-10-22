package br.com.horta_viva

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import br.com.horta_viva.databinding.ActivityBottomFragmentBinding

class BottomFragment : AppCompatActivity() {

    private lateinit var binding : ActivityBottomFragmentBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBottomFragmentBinding.inflate(layoutInflater)
        setContentView(binding.root)
        replaceFragment(home())

        binding.bottomNavigation.setOnItemSelectedListener {
            when(it.itemId){
                R.id.buttonHome -> replaceFragment(home())
                R.id.buttonCart -> replaceFragment(loja())
                R.id.buttonProfile -> replaceFragment(Colaborador())

                else->{

                }
            }
            true
        }
    }

    private fun replaceFragment(activity: Activity){
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame_layout, activity)
        fragmentTransaction.commit()
    }
}

private fun FragmentTransaction.replace(frameLayout: Int, activity: Activity) {

}

