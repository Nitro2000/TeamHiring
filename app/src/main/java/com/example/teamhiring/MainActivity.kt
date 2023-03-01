@file:Suppress("DEPRECATION")

package com.example.teamhiring

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.teamhiring.databinding.ActivityMainBinding
import com.example.teamhiring.presentation.viewmodels.CommonViewModel
import com.google.android.material.bottomnavigation.BottomNavigationView
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController
    private val viewModel: CommonViewModel by viewModels()
    private var isEmployee: Boolean = true
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.navHostFragment) as NavHostFragment
        navController = navHostFragment.navController

        viewModel.getUserType().observe(this) {
            binding.mainBottomNav.menu.clear()
            if (it) {
                binding.mainBottomNav.inflateMenu(R.menu.bottom_nav_menu)
            } else {
                isEmployee = false
                binding.mainBottomNav.inflateMenu(R.menu.recruiter_nav_menu)
            }
        }

        binding.mainBottomNav.setupWithNavController(navController)
        binding.mainBottomNav.setOnItemSelectedListener { item ->
            if (isEmployee) popEmpBackStack(item.itemId == R.id.homeFragmentSeeker)
            else popRecBackStack(item.itemId == R.id.recruiterHomeFragment)
            when (item.itemId) {
                R.id.homeFragmentSeeker -> {
                    navController.navigate(R.id.homeFragmentSeeker)
                }
                R.id.appliedJobFragment -> {
                    navController.navigate(R.id.appliedJobFragment)
                }
                R.id.chatFragment -> {
                    navController.navigate(R.id.chatFragment)
                }
                R.id.profileFragment -> {
                    navController.navigate(R.id.profileFragment)
                }
                R.id.recruiterHomeFragment -> {
                    navController.navigate(R.id.recruiterHomeFragment)
                }
                R.id.recruiterInteractedFragment -> {
                    navController.navigate(R.id.recruiterInteractedFragment)
                }
                R.id.recruiterProfileFragment -> {
                    navController.navigate(R.id.recruiterProfileFragment)
                }
            }
            true
        }
//        setupNav()
    }

    private fun setupNav() {

        navController.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                R.id.homeFragmentSeeker -> showBottomNav()
                R.id.appliedJobFragment -> showBottomNav()
                R.id.profileFragment -> showBottomNav()
                R.id.chatFragment -> showBottomNav()
                else -> showBottomNav()
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

    fun popEmpBackStack(include: Boolean) {
        navController.popBackStack(R.id.homeFragmentSeeker, include)
    }

    fun popRecBackStack(include: Boolean) {
        navController.popBackStack(R.id.recruiterHomeFragment, include)
    }
}