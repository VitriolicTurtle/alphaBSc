package com.cn.bsc.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.cn.bsc.R
import com.cn.bsc.databinding.FragmentRegisterBinding
import com.cn.bsc.databinding.FragmentUserProfileBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore


class UserProfileFragment : Fragment(){
    private lateinit var binding: FragmentUserProfileBinding
    private val db = FirebaseFirestore.getInstance()
    private lateinit var auth: FirebaseAuth

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, avedInstanceState: Bundle?): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_user_profile, container, false)


        val buttonSettings = binding.root.findViewById<Button>(R.id.settings_button)
        val buttonFriends = binding.root.findViewById<Button>(R.id.friends_button)
        val buttonUserInfo = binding.root.findViewById<Button>(R.id.user_info_button)

        buttonSettings.setOnClickListener(){
            findNavController().navigate(R.id.dest_settings)
        }

        buttonFriends.setOnClickListener(){
            findNavController().navigate(R.id.dest_friends_list)
        }

        buttonUserInfo.setOnClickListener(){
            findNavController().navigate(R.id.dest_user)
        }


        return binding.root
    }





}
