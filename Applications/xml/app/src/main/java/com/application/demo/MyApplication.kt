package com.application.demo

import android.app.Application
import android.content.Context
import androidx.appcompat.app.AppCompatDelegate

class MyApplication : Application() {

  override fun onCreate() {
    super.onCreate()

    val prefs = getSharedPreferences(Constants.PREFS_MODE, Context.MODE_PRIVATE)

    val nightMode = when (prefs.getInt(Constants.MODE_KEY, 0)) {
      Mode.LIGHT.ordinal -> AppCompatDelegate.MODE_NIGHT_NO
      Mode.DARK.ordinal -> AppCompatDelegate.MODE_NIGHT_YES
      Mode.SYSTEM.ordinal -> AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM
      else -> AppCompatDelegate.MODE_NIGHT_NO
    }

    AppCompatDelegate.setDefaultNightMode(nightMode)

  }
}