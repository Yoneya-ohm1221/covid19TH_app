package com.example.covid19th.Ui.Fragment

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.covid19th.databinding.FragmentHomeBinding
import com.example.covid19th.model.Covid
import com.example.covid19th.utils.Constants
import com.example.covid19th.utils.CovidAdapter
import com.example.covid19th.viewmodel.CovidViewModel
import dagger.hilt.android.AndroidEntryPoint
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private lateinit var covidAdapter :CovidAdapter
    private val viewModel:CovidViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        viewModel.allCovid()
        return binding.root
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        covidAdapter = CovidAdapter()
        binding.recyclerView.adapter = covidAdapter

        viewModel.covid.observe(viewLifecycleOwner) {
            covidAdapter.submitList(it)
        }

        searchAction()
        binding.datenow.text= Constants.DATE_NOW
    }

    private fun searchAction() {
        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            val dataSearch = ArrayList<Covid>()
            override fun onQueryTextSubmit(p0: String?): Boolean {
                return false
            }

            @SuppressLint("FragmentLiveDataObserve")
            override fun onQueryTextChange(newText: String?): Boolean {
                    dataSearch.clear()
                    viewModel.covid.observe(this@HomeFragment) { it ->
                        if(newText!=""){
                            dataSearch.addAll(it!!)
                            covidAdapter.submitList(dataSearch.filter { it.province.contains(newText!!) })
                        }else{
                            covidAdapter.submitList(it)
                        }

                    }

               return false
            }
        })
    }

}