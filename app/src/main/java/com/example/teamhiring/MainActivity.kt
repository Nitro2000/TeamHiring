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
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.navHostFragment) as NavHostFragment

        navController=navHostFragment.navController
        binding.mainBottomNav.setupWithNavController(navController)
        binding.mainBottomNav.setOnItemSelectedListener { item ->
            popBackStack(item.itemId == R.id.homeFragmentSeeker)
            when (item.itemId) {
                R.id.homeFragmentSeeker -> {
                    navController.navigate(R.id.homeFragmentSeeker)
                }
                R.id.appliedJobFragment -> {
                    navController.navigate(R.id.appliedJobFragment)
                }
                R.id.chatFragment -> {
                    navController.navigate(R.id.chatCompanyFragment)
                }
                R.id.profileFragment -> {
                    navController.navigate(R.id.profileFragment)
                }
            }
            true
        }
        setupNav()
    }

    private fun setupNav() {

        navController.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                R.id.homeFragmentSeeker -> showBottomNav()
                R.id.appliedJobFragment -> showBottomNav()
                R.id.profileFragment -> showBottomNav()
                R.id.chatCompanyFragment -> showBottomNav()
                else -> hideBottomNav()
            }
        }
    }


    fun bottomNavBarVisibility(visibility: Int) {
        binding.mainBottomNav.visibility = visibility
    }
    private fun showBottomNav() {
        binding.mainBottomNav.visibility = View.VISIBLE

    }
    private fun hideBottomNav() {
        binding.mainBottomNav.visibility = View.GONE
    }

    fun popBackStack(include: Boolean) {
        navController.popBackStack(R.id.homeFragmentSeeker, include)
    }
}