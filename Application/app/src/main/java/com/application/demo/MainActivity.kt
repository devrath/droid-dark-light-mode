package com.application.demo

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.application.demo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

  private lateinit var binding: ActivityMainBinding

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)
    binding = ActivityMainBinding.inflate(layoutInflater)
    setContentView(binding.root)
    binding.changeModeButton.setOnClickListener { changeMode() }
  }

  private fun changeMode() {
    val settingsFragment = SettingsFragment()
    settingsFragment.show(supportFragmentManager, "SettingsFragment")
  }

}
