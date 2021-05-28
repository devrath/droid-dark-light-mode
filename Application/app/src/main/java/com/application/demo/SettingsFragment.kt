package com.application.demo

import android.content.Context
import android.content.SharedPreferences
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioGroup
import androidx.appcompat.app.AppCompatDelegate
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.DialogFragment
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kotlinx.android.synthetic.main.fragment_settings.*

class SettingsFragment : BottomSheetDialogFragment(), RadioGroup.OnCheckedChangeListener {

    private lateinit var prefs: SharedPreferences

    override fun onStart() {
        super.onStart()

        dialog?.window?.setLayout(
            ConstraintLayout.LayoutParams.MATCH_PARENT,
            ConstraintLayout.LayoutParams.WRAP_CONTENT
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_settings, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        modeGroup.setOnCheckedChangeListener(this)
        prefs = requireActivity().getSharedPreferences(Constants.PREFS_MODE, Context.MODE_PRIVATE)

        when (prefs.getInt(Constants.MODE_KEY, 0)) {
            Mode.LIGHT.ordinal -> light.isChecked = true
            Mode.DARK.ordinal -> dark.isChecked = true
            Mode.SYSTEM.ordinal, Mode.BATTERY.ordinal -> system.isChecked = true
            else -> light.isChecked = true
        }

        if (isPreAndroid10()) {
            system.text = getString(R.string.battery_saver)
        }
    }

    override fun onCheckedChanged(rg: RadioGroup?, checkedId: Int) {
        when (checkedId) {
            R.id.light -> switchToMode(AppCompatDelegate.MODE_NIGHT_NO, Mode.LIGHT)
            R.id.dark -> switchToMode(AppCompatDelegate.MODE_NIGHT_YES, Mode.DARK)
            R.id.system -> {
                if (isPreAndroid10()) {
                    switchToMode(AppCompatDelegate.MODE_NIGHT_AUTO_BATTERY, Mode.BATTERY)
                } else {
                    switchToMode(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM, Mode.SYSTEM)
                }
            }
        }
    }

    private fun isPreAndroid10() = Build.VERSION.SDK_INT < Build.VERSION_CODES.Q

    private fun switchToMode(nightMode: Int, mode: Mode) {
        // Set the mode of the device based on the selection made
        AppCompatDelegate.setDefaultNightMode(nightMode)
        // Save the user selection to preferences
        prefs.edit().putInt(Constants.MODE_KEY, mode.ordinal).apply()
    }

}