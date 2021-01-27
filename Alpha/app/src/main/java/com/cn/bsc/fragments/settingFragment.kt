package com.cn.bsc.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatDelegate
import androidx.databinding.DataBindingUtil
import com.cn.bsc.MainActivity
import com.cn.bsc.R
import com.cn.bsc.databinding.FragmentSettingBinding
import com.cn.bsc.sharedprefs
import kotlinx.android.synthetic.main.fragment_setting.*

class SettingFragment : Fragment() {
    private lateinit var binding: FragmentSettingBinding
    private lateinit var savedDarkData: sharedprefs

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_setting, container, false)


        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        d_modes.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked){
                savedDarkData = sharedprefs(requireContext() as MainActivity)
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                savedDarkData.setDarkModeState(true)
            } else{
                savedDarkData = sharedprefs(requireContext() as MainActivity)
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                savedDarkData.setDarkModeState(false)
            }
        }

        savedDarkData = sharedprefs(requireContext() as MainActivity)

        if(savedDarkData.loadDarkModeState() == true){
            d_modes.toggle()                   //because the switch is defaulted to off, toggle will set that on on but only if darkmode was enabled after closing the app.
        }

        button.setOnClickListener{
            savedDarkData = sharedprefs(requireContext() as MainActivity)

            savedDarkData.setRedModeState(true)
            savedDarkData.setPurpleModeState(false)
            savedDarkData.setGreenModeState(false)
            savedDarkData.setOrangeModeState(false)
            val toast = Toast.makeText(requireContext() as MainActivity, "Please restart the app to apply the Red theme", Toast.LENGTH_SHORT)
            toast.show()


        }

        button2.setOnClickListener{
            savedDarkData = sharedprefs(requireContext() as MainActivity)

            savedDarkData.setRedModeState(false)
            savedDarkData.setPurpleModeState(false)
            savedDarkData.setGreenModeState(true)
            savedDarkData.setOrangeModeState(false)
            val toast = Toast.makeText(requireContext() as MainActivity, "Please restart the app to apply the Green theme", Toast.LENGTH_SHORT)
            toast.show()

        }

        button3.setOnClickListener{
            savedDarkData = sharedprefs(requireContext() as MainActivity)

            savedDarkData.setRedModeState(false)
            savedDarkData.setPurpleModeState(true)
            savedDarkData.setGreenModeState(false)
            savedDarkData.setOrangeModeState(false)

            val toast = Toast.makeText(requireContext() as MainActivity, "Please restart the app to apply the Purple theme", Toast.LENGTH_SHORT)
            toast.show()

        }

        button4.setOnClickListener{
            savedDarkData = sharedprefs(requireContext() as MainActivity)

            savedDarkData.setRedModeState(false)
            savedDarkData.setOrangeModeState(true)
            savedDarkData.setGreenModeState(false)
            savedDarkData.setPurpleModeState(false)
            val toast = Toast.makeText(requireContext() as MainActivity, "Please restart the app to apply the Orange theme", Toast.LENGTH_SHORT)
            toast.show()

        }

        button5.setOnClickListener{
            savedDarkData = sharedprefs(requireContext() as MainActivity)

            savedDarkData.setRedModeState(false)
            savedDarkData.setOrangeModeState(false)
            savedDarkData.setGreenModeState(false)
            savedDarkData.setPurpleModeState(false)
            val toast = Toast.makeText(requireContext() as MainActivity, "Please restart the app to apply the Default theme", Toast.LENGTH_SHORT)
            toast.show()

        }

    }


}