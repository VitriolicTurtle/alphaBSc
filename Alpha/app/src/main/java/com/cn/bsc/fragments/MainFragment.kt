package com.cn.bsc.fragments

import android.database.DatabaseUtils
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController

import com.cn.bsc.R
import com.cn.bsc.databinding.FragmentMainBinding
import kotlinx.android.synthetic.main.fragment_main.*

class MainFragment : Fragment() {
    private lateinit var binding: FragmentMainBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, avedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_main, container, false)


        val goToLogin = binding.root.findViewById<Button>(R.id.btnLogin)
        val goToRegister = binding.root.findViewById<Button>(R.id.btnRegister)

        goToLogin.setOnClickListener(){
            //val loginFragment = LoginFragment()
            //childFragmentManager.beginTransaction()
            //        .replace(R.id.flFragment, loginFragment)
            //        .addToBackStack(null)
            //        .commit()
            findNavController().navigate(R.id.dest_login)
        }

        goToRegister.setOnClickListener(){
            //val registerFragment = RegisterFragment()
            //childFragmentManager.beginTransaction()
            //        .replace(R.id.flFragment, registerFragment)
            //        .addToBackStack(null)
            //        .commit()
            findNavController().navigate(R.id.dest_register)
        }


        return binding.root
    }


}
