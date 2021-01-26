package com.cn.bsc.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.cn.bsc.R
import com.cn.bsc.databinding.FragmentClassroomIndexBinding


class ClassroomIndexFragment : Fragment() {
    private lateinit var binding: FragmentClassroomIndexBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_classroom_index, container, false)



        return binding.root
    }
}