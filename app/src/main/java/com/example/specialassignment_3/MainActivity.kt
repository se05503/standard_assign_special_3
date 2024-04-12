package com.example.specialassignment_3

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import com.example.specialassignment_3.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.apply {
            tabHome.setOnClickListener {
                setFragment(HomeFragment())
            }
            tabDashboard.setOnClickListener {
                setFragment(DashBoardFragment())
            }
            tabNotification.setOnClickListener {
                setFragment(NotificationFragment())
            }
        }
    }

    private fun setFragment(fragment: Fragment) {
        supportFragmentManager.commit {
            replace(R.id.frame_layout,fragment)
            setReorderingAllowed(true)
            addToBackStack("")
        }
    }
}