package com.application.demo

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    pressMeButton.setOnClickListener {
      Snackbar.make(coordinatorLayout as View, getString(R.string.button_pressed), Snackbar.LENGTH_SHORT).show()
    }
  }

  override fun onCreateOptionsMenu(menu: Menu?): Boolean {
    menuInflater.inflate(R.menu.menu_settings, menu)
    return super.onCreateOptionsMenu(menu)
  }

  override fun onOptionsItemSelected(item: MenuItem): Boolean {
    when (item.itemId) {
      R.id.settingsItem -> {
        val settingsFragment = SettingsFragment()
        settingsFragment.show(supportFragmentManager, "SettingsFragment")
      }
    }
    return super.onOptionsItemSelected(item)
  }
}
