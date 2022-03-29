package com.example.covid19th.Ui.Fragment

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.covid19th.R
import com.example.covid19th.databinding.FragmentHistoryBinding
import com.example.covid19th.utils.Constants
import com.example.covid19th.viewmodel.CovidViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HistoryFragment : Fragment() {
    lateinit var binding: FragmentHistoryBinding
    private val viewModel: CovidViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHistoryBinding.inflate(inflater,container,false)
        viewModel.getTotalCovid()
        return binding.root
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.totalCovid.observe(viewLifecycleOwner){
            binding.apply {
                txtnewcaseAll.text = "+"+it[0].newCase
                txttotalAll.text = it[0].totalCase
                txtdeadAll.text = "+"+it[0].newDeath
                txttotalDeadAll.text = it[0].totalDeath
                txtrecoveredAll.text="+"+it[0].newRecovered
                txttotalrecoveredAll.text=it[0].totalRecovered
                txttotalexcludeabroadDetail.text="+"+it[0].newCaseExcludeabroad
                txtdetaildate.text = Constants.DATE_NOW
            }
        }
    }

}