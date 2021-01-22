package com.cn.bsc.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.cn.bsc.R
import kotlinx.android.synthetic.main.fragment_main.*

class MainFragment : Fragment() {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_main, container, false)


        val goToLogin = view.findViewById<Button>(R.id.btnLogin)
        val goToRegister = view.findViewById<Button>(R.id.btnRegister)

        goToLogin.setOnClickListener(){
            val loginFragment = LoginFragment()
            childFragmentManager.beginTransaction()
                    .replace(R.id.flFragment, loginFragment)
                    .addToBackStack(null)
                    .commit()
        }

        goToRegister.setOnClickListener(){
            val registerFragment = RegisterFragment()
            childFragmentManager.beginTransaction()
                    .replace(R.id.flFragment, registerFragment)
                    .addToBackStack(null)
                    .commit()
        }


        return view

    }


}
