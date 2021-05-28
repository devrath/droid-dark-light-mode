package com.application.demo

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    changeModeButton.setOnClickListener { changeMode() }
  }

  override fun onCreateOptionsMenu(menu: Menu?): Boolean {
    menuInflater.inflate(R.menu.menu_settings, menu)
    return super.onCreateOptionsMenu(menu)
  }

  override fun onOptionsItemSelected(item: MenuItem): Boolean {
    when (item.itemId) {
      R.id.settingsItem -> {
        changeMode()
      }
    }
    return super.onOptionsItemSelected(item)
  }

  private fun changeMode() {
    val settingsFragment = SettingsFragment()
    settingsFragment.show(supportFragmentManager, "SettingsFragment")
  }
}
