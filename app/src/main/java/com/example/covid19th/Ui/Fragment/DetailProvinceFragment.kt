package com.example.covid19th.Ui.Fragment

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.covid19th.R
import com.example.covid19th.databinding.FragmentDetailProvinceBinding
import com.example.covid19th.model.Covid
import com.example.covid19th.utils.Constants

class DetailProvinceFragment : Fragment() {

    lateinit var binding: FragmentDetailProvinceBinding
    private var data:Covid?=null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailProvinceBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val args =arguments
         data = args!!.get("data") as Covid
        setData()

    }


    @SuppressLint("SetTextI18n")
    private fun setData(){
        binding.imgback.setOnClickListener {
            requireActivity().onBackPressed()
        }
        binding.apply {
            txtprovinceD.text = data!!.province
            txtdetaildate.text = Constants.DATE_NOW
            txtnewcaseDetail.text = "+"+data!!.new_case
            txttotalDetail.text = data!!.total_case
            txttotalDeadDetail.text=data!!.total_death
            txtdeadDetail.text="+"+data!!.new_death
            txttotalexcludeabroadDetail.text="+"+data!!.new_case_excludeabroad
        }


    }
}