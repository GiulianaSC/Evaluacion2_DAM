package com.giuliana.ec2_dam

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.giuliana.ec2_dam.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val fragment = CameraFragment()
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, fragment)
            .commit()
        val bottomNavigation = binding.btnView
        bottomNavigation.setOnNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.item_camara-> {
                    val fragment = CameraFragment()
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fragmentContainer, fragment)
                        .commit()
                    true
                }
                R.id.item_mapa -> {
                    val fragment = MapsFragment()
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fragmentContainer, fragment)
                        .commit()
                    true
                }
                R.id.item_info -> {
                    val fragment = InfoFragment()
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fragmentContainer, fragment)
                        .commit()
                    true
                }
                else -> false
            }
        }
    }
}