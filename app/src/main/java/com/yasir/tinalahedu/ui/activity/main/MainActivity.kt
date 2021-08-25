package com.yasir.tinalahedu.ui.activity.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.yasir.tinalahedu.R
import com.yasir.tinalahedu.ui.fragment.HomeFragment
import com.yasir.tinalahedu.ui.fragment.ProfileFragment

class MainActivity : AppCompatActivity() {
    val fragmentHome : Fragment = HomeFragment()
    val fragmentProfile : Fragment = ProfileFragment()
    val fm : FragmentManager = supportFragmentManager
    var active : Fragment = fragmentHome

    private lateinit var menu: Menu
    private lateinit var menuItem: MenuItem
    private lateinit var buttomNavigationView: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupNavButtomNavigation()
    }

    fun setupNavButtomNavigation(){
        fm.beginTransaction().add(R.id.container, fragmentHome).show(fragmentHome).commit()
        fm.beginTransaction().add(R.id.container, fragmentProfile).hide(fragmentProfile).commit()

        buttomNavigationView = findViewById(R.id.nav_view)
        menu = buttomNavigationView.menu
        menuItem = menu.getItem(0)
        menuItem.isChecked = true

        buttomNavigationView.setOnNavigationItemSelectedListener{
            when(it.itemId){
                R.id.navigation_home -> {
                    callFragment(0, fragmentHome)
                }
                R.id.navigation_profile -> {
                    callFragment(1, fragmentProfile)
                }
            }
            false
        }
    }

    fun callFragment(int : Int, fragment: Fragment){
        menuItem = menu.getItem(int)
        menuItem.isChecked = true
        fm.beginTransaction().hide(active).show(fragment).commit()
        active = fragment
    }
}