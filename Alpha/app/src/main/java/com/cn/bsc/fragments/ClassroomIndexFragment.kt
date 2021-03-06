package com.cn.bsc.fragments

import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.cn.bsc.Adapters.ClassroomIndexRecyclerAdapter
import com.cn.bsc.R
import com.cn.bsc.databinding.FragmentClassroomIndexBinding
import java.util.*


class ClassroomIndexFragment : Fragment() {
    private lateinit var binding: FragmentClassroomIndexBinding
    private var textList: ArrayList<String> = ArrayList()
    private lateinit var adapter: ClassroomIndexRecyclerAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_classroom_index, container, false)
        adapter = ClassroomIndexRecyclerAdapter(textList)
        binding.recyclerViewClasses.adapter = adapter
        binding.recyclerViewClasses.layoutManager = LinearLayoutManager(context)

        binding.btnCreateModule.setOnClickListener() {
            val builder = AlertDialog.Builder(context)
            val dialogLayout = inflater.inflate(R.layout.prompt_join_classroom, null)
            val editText  = dialogLayout.findViewById<EditText>(R.id.editText)
            builder.setView(dialogLayout)
            builder.setPositiveButton("OK") { dialogInterface, i ->
                textList.add(editText.text.toString())
                adapter.notifyItemInserted(textList.size - 1)
            }
            builder.show()
        }
        return binding.root
    }
}