package com.example.cs473resume

import android.R
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.cs473resume.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

     lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
    private fun replaceFragment(fragment: Fragment) {
        val fragmentManager=supportFragmentManager
        val fragmentTransaction=fragmentManager.beginTransaction()
       fragmentTransaction.replace(binding.fragmentContainer.id,fragment)
        fragmentTransaction.commit()
    }
    fun Home(view: View){
        replaceFragment(HomeFragment())
    }
    fun About(view: View){
        replaceFragment(AboutFragment())
    }
    fun Experience(view: View){
        replaceFragment(ExperienceFragment())
    }
    fun Contact(view: View){
        replaceFragment(ContactFragment())
    }

}