@file:Suppress("DEPRECATION")

package com.example.teamhiring

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.teamhiring.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.navHostFragment) as NavHostFragment

        navController=navHostFragment.navController
        binding.mainBottomNav.setupWithNavController(navController)

        binding.mainBottomNav.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.menu_home -> {

                    navController.navigate(R.id.homeFragmentSeeker)
                    true
                }
                R.id.menu_applied -> {
                    navController.navigate(R.id.appliedJobFragment)
                    true
                }
                R.id.menu_chat -> {
                    navController.navigate(R.id.chatCompanyFragment)
                    true
                }
                R.id.menu_profile -> {
                    navController.navigate(R.id.profileFragment)
                    true
                }
                else-> true
            }
            true
        }

//        setupNav()
    }

//    private fun setupNav() {
//
//        navController.addOnDestinationChangedListener { _, destination, _ ->
//            when (destination.id) {
//                R.id.homeFragmentSeeker -> showBottomNav()
//                R.id.appliedJobFragment -> showBottomNav()
//                R.id.profileFragment -> showBottomNav()
//                R.id.chatFragment -> showBottomNav()
//                else -> hideBottomNav()
//            }
//        }
//    }


    fun bottomNavBarVisibility(visibility: Int) {
        binding.mainBottomNav.visibility = visibility
    }
//    private fun showBottomNav() {
//        binding.mainBottomNav.visibility = View.VISIBLE
//
//    }
//    private fun hideBottomNav() {
//        binding.mainBottomNav.visibility = View.GONE
//
//    }
}