package com.example.weatherapp2.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.weatherapp2.R
import com.example.weatherapp2.adapters.WeatherAdapter
import com.example.weatherapp2.adapters.WeatherModel
import com.example.weatherapp2.databinding.FragmentHoursBinding


class HoursFragment : Fragment() {

    private lateinit var binding: FragmentHoursBinding
    private lateinit var adapter: WeatherAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View  {
        binding = FragmentHoursBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRcView()
    }

    private fun initRcView() = with(binding){
        rcView.layoutManager = LinearLayoutManager(activity)
        adapter = WeatherAdapter()
        rcView.adapter = adapter
        val list = listOf(
            WeatherModel(
                "","17:00","Sunny","-5","",
                "","", ""),
            WeatherModel(
                    "","18:00","Sunny","-5","",
            "","", ""),
            WeatherModel(
                "","19:00","Sunny","-4","",
                "","", "")

        )
        adapter.submitList(list)


    }

    companion object {

        @JvmStatic
        fun newInstance() = HoursFragment()
    }
}