package com.example.nav_drawer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var drawerlayout: DrawerLayout
    private lateinit var actionBarDrawerToggle: ActionBarDrawerToggle
    private lateinit var navigationView: NavigationView
    val missionFrag = MissionFragment()
    val projectFrag = ProjectFragment()
    val aboutUsFrag = AboutUsFragment()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setCurrentFragment(missionFrag)
        drawer_func()


    }

    private fun drawer_func(){
        drawerlayout = findViewById(R.id.my_drawer_layout)
        navigationView = findViewById(R.id.navigation_view)
        actionBarDrawerToggle = ActionBarDrawerToggle(this, drawerlayout, R.string.nav_open, R.string.nav_close)

        drawerlayout.addDrawerListener(actionBarDrawerToggle)
        actionBarDrawerToggle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        navigationView.setNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.nav_mission -> {
                    drawerlayout.closeDrawer(GravityCompat.START)
                    setCurrentFragment(missionFrag)
                    true
                }
                R.id.nav_project-> {
                    drawerlayout.closeDrawer(GravityCompat.START)
                    setCurrentFragment(projectFrag)
                    true
                }
                R.id.nav_aboutUs-> {
                    drawerlayout.closeDrawer(GravityCompat.START)
                    setCurrentFragment(aboutUsFrag)
                    true
                }
                else -> false
            }
        }
    }

    private fun setCurrentFragment(fragment: Fragment) =
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.framefl, fragment)
            commit()
        }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return if (actionBarDrawerToggle.onOptionsItemSelected(item)) {
            true
        } else super.onOptionsItemSelected(item)
    }
}