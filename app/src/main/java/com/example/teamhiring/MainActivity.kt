@file:Suppress("DEPRECATION")

package com.example.teamhiring

import android.Manifest
import android.content.pm.PackageManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import androidx.work.Data
import androidx.work.ExistingWorkPolicy
import androidx.work.OneTimeWorkRequest
import androidx.work.WorkManager
import com.example.teamhiring.databinding.ActivityMainBinding
import com.example.teamhiring.helpers.NotifyWork
import com.example.teamhiring.helpers.NotifyWork.Companion.NOTIFICATION_ID
import com.example.teamhiring.helpers.NotifyWork.Companion.NOTIFICATION_WORK
import dagger.hilt.android.AndroidEntryPoint
import java.util.concurrent.TimeUnit

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var checkNotificationPermission: ActivityResultLauncher<String>
    private var isPermission = false

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

        checkNotificationPermission = registerForActivityResult(
            ActivityResultContracts.RequestPermission()
        ) { isGranted: Boolean ->
            isPermission = isGranted
        }

        checkPermission()
        setupNav()

    }

    private fun checkPermission() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            if (ContextCompat.checkSelfPermission(
                    this,
                    Manifest.permission.POST_NOTIFICATIONS
                ) == PackageManager.PERMISSION_GRANTED
            ) {
                isPermission = true
            } else {
                isPermission = false

                checkNotificationPermission.launch(Manifest.permission.POST_NOTIFICATIONS)
            }
        } else {
            isPermission = true
        }
    }
    private fun scheduleNotification(data: Data) {
        Log.d("Devashish","Note1")
        val notificationWork = OneTimeWorkRequest.Builder(NotifyWork::class.java)
            .setInitialDelay(5000,TimeUnit.MILLISECONDS).setInputData(data).build()

        val instanceWorkManager = WorkManager.getInstance(this)
        instanceWorkManager.beginUniqueWork(
            NotifyWork.NOTIFICATION_WORK,
            ExistingWorkPolicy.REPLACE, notificationWork).enqueue()
        Log.d("Devashish","Note2")
    }


    private fun setupNav() {
        val currentTime = System.currentTimeMillis()
        val data = Data.Builder().putInt(NotifyWork.NOTIFICATION_ID, 0).build()
        Log.d("Devashish","Note3"+currentTime)
        scheduleNotification(data)
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