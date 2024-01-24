package com.example.storieapp.UI

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.example.storieapp.R
import com.example.storieapp.Utils.ConnectivityRepository
import com.example.storieapp.ViewModels.ConnectivityViewModal
import com.example.storieapp.ViewModels.ConnectivityViewModelFactory

class MainActivity : AppCompatActivity() {
    private lateinit var navController: NavController;

    private val viewModel: ConnectivityViewModal by viewModels {
        ConnectivityViewModelFactory(ConnectivityRepository(applicationContext))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupNavController();
        setupConnectivityTracking()
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }

    fun setupNavController(){
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        navController = navHostFragment.navController
    }

    fun setupConnectivityTracking(){
        viewModel.isOnline.observe(this) { isOnline ->
            if (isOnline) {
                supportFragmentManager.popBackStack()
            } else {
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.fragmentContainerView, ConnectivityFragment())
                    .addToBackStack(null)
                    .commit()
            }
        }
    }
}