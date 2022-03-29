package com.example.covid19th.utils

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.covid19th.R
import com.example.covid19th.databinding.ViewCovidBinding
import com.example.covid19th.model.Covid


class CovidAdapter: ListAdapter<Covid, CovidAdapter.ViewHolder>(MyDiffItemCallback()) {
    class ViewHolder(val binding: ViewCovidBinding):RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CovidAdapter.ViewHolder {
        return ViewHolder(ViewCovidBinding.inflate(LayoutInflater.from(parent.context)))
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: CovidAdapter.ViewHolder, position: Int) {
        val data =getItem(position)
        holder.binding.apply {
            txtprovince.text = data.province
            txtnewcase.text="+"+data.new_case
            txtnewdead.text="+"+data.new_death
            txttotalcase.text=data.total_case
            txtdate.text="Update : "+data.update_date
        }

        holder.itemView.setOnClickListener {
            val bundle = Bundle()
            bundle.putParcelable("data",data)
            it.findNavController().navigate(R.id.action_homeFragment_to_detailProvinceFragment,bundle)
        }
    }

    internal  class MyDiffItemCallback :DiffUtil.ItemCallback<Covid>(){
        override fun areItemsTheSame(oldItem: Covid, newItem: Covid): Boolean {
            return oldItem.province == newItem.province
        }

        override fun areContentsTheSame(oldItem: Covid, newItem: Covid): Boolean {
            return oldItem == newItem
        }

    }

}







