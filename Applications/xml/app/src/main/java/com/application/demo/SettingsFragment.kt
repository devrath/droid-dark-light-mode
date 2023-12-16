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
import com.application.demo.databinding.FragmentSettingsBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class SettingsFragment : BottomSheetDialogFragment(), RadioGroup.OnCheckedChangeListener {

    private var _binding: FragmentSettingsBinding? = null
    private val binding get() = _binding!!

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
        _binding = FragmentSettingsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.modeGroup.setOnCheckedChangeListener(this)
        prefs = requireActivity().getSharedPreferences(Constants.PREFS_MODE, Context.MODE_PRIVATE)

        when (prefs.getInt(Constants.MODE_KEY, 0)) {
            Mode.LIGHT.ordinal -> binding.light.isChecked = true
            Mode.DARK.ordinal -> binding.dark.isChecked = true
            Mode.SYSTEM.ordinal, Mode.BATTERY.ordinal -> binding.system.isChecked = true
            else -> binding.light.isChecked = true
        }

        if (isPreAndroid10()) {
            binding.system.text = getString(R.string.battery_saver)
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

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}