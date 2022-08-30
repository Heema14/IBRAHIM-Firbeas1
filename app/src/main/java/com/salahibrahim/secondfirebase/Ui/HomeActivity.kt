package com.salahibrahim.secondfirebase.Ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.salahibrahim.secondfirebase.Fragments.HartFragment
import com.salahibrahim.secondfirebase.Fragments.HomeFragment
import com.salahibrahim.secondfirebase.Fragments.SearchFragment
import com.salahibrahim.secondfirebase.Fragments.UserFragment
import com.salahibrahim.secondfirebase.R

class HomeActivity : AppCompatActivity() {

    private var doubleBackToExit = false
    override fun onBackPressed() {
        if (doubleBackToExit) {
            super.onBackPressed()
            return
        }

        doubleBackToExit = true
        Toast.makeText(this, "Press again to exit", Toast.LENGTH_SHORT).show()
        Handler().postDelayed({ doubleBackToExit = false }, 2000)
    }
//    private lateinit var out: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

//        out = findViewById(R.id.logout)
//
//        out.setOnClickListener {
//            FirebaseAuth.getInstance().signOut()
//            startActivity(Intent(this,LoginActivity::class.java))
//        }

        openFragment(HomeFragment())
//        setSupportActionBar(findViewById(R.id.toolbar))

        findViewById<FloatingActionButton>(R.id.fab).setOnClickListener {
            startActivity(Intent(this,NewPostActivity::class.java))
        }

        findViewById<BottomNavigationView>(R.id.bottom_nav_view).setOnItemSelectedListener {
            when (it.itemId){
                R.id.menu_home -> {
                    openFragment(HomeFragment())
                    true
                }
                R.id.menu_search -> {
                    openFragment(SearchFragment())
                    true
                }
                R.id.menu_hart -> {
                    openFragment(HartFragment())
                    true
                }
                R.id.menu_user -> {
                    openFragment(UserFragment())
                    true
                }
                else -> {
                    openFragment(HomeFragment())
                    true
                }
            }
        }
    }

    private fun openFragment(msg: Fragment){

        val fn = supportFragmentManager
        val fragmentTransition: FragmentTransaction = fn.beginTransaction().remove(msg)
        fragmentTransition.replace(R.id.container, msg)
        fragmentTransition.commit()
    }
}