package com.example.learnenglishapp
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login)

        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.nav_host_fragment) as? NavHostFragment

        val navController = navHostFragment?.navController

        if (navController != null) {
            val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_navigation)
            NavigationUI.setupWithNavController(bottomNavigationView, navController)
            Log.d("MainActivity", "BottomNavigationView đã được thiết lập với NavController")
        } else {
            Log.e("MainActivity", "NavController not found!")
        }
    }
}



