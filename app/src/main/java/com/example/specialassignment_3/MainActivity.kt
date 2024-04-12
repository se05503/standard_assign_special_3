package com.example.specialassignment_3

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import com.example.specialassignment_3.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabItem
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val tableLayout = binding.tableLayout
        val homeTab = tableLayout.getTabAt(0)
        val dashboardTab = tableLayout.getTabAt(1)
        val notificationTab = tableLayout.getTabAt(2)

        tableLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                when(tab) {
                    homeTab -> {
                        setFragment(HomeFragment())
                    }
                    dashboardTab -> {
                        setFragment(DashBoardFragment())
                    }
                    notificationTab -> {
                        setFragment(NotificationFragment())
                    }
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
            }
        })
    }

    private fun setFragment(fragment: Fragment) {
        supportFragmentManager.commit {
            replace(R.id.frame_layout,fragment)
            setReorderingAllowed(true)
            addToBackStack("")
        }
    }
}