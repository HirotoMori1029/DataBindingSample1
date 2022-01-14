package com.hirogram.databindingsample1

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.hirogram.databindingsample1.databinding.ActivityMainBinding
import com.hirogram.databindingsample1.databinding.ListExampleBinding
import java.security.AccessControlContext
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding: ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        val adapter = MainListAdapter(this).apply {
            add(ListItem("ゴミ出し", Date()))
            add(ListItem("技術書を書く", Date()))
            add(ListItem("脱稿する", Date()))
        }
        binding.listView.adapter = adapter
    }
}

class MainListAdapter(context: Context): ArrayAdapter<ListItem>(context, 0) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val binding: ListExampleBinding
        if (convertView == null) {
            binding = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.list_example,
            parent, false)
            binding.root.tag = binding
        } else {
            binding = convertView.tag as ListExampleBinding
        }
        binding.item = getItem(position)
        return binding.root
    }
}