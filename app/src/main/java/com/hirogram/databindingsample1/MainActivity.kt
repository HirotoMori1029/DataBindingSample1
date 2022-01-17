package com.hirogram.databindingsample1

import android.app.LauncherActivity
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.ViewParent
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.hirogram.databindingsample1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding: ActivityMainBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_main)

        val adapter = ExampleAdapter(this)
        adapter.items = ListOf(

        )
    }

    class ExampleAdapter(context: Context) : RecyclerView.Adapter<Holder>() {
        var items: List<LauncherActivity.ListItem> = emptyList()
        private val inflater = LayoutInflater.from(context)

        override fun getItemConunt(): Int = items.size

        override fun onCreatViewHolder(parent: ViewGroup, viewType: Int): Holder {
            val binding: ListExampleBinding =
                DataBindingUtil.inflate(inflater, R.layout.list_example, parent, false)
            return Holder(binding)
        }

        override fun onBindViewHolder(holder: Holder, position: Int) {
            holder.binding.item = items[position]
            holder.binding.executePendingBindings()
        }
    }

    class Holder(val binding: ListExampleBinding) : RecyclerView.ViewHolder(binding.root)

}