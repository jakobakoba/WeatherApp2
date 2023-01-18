package com.example.weatherapp2

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.weatherapp2.databinding.ActivityMainBinding
import org.json.JSONObject

const val API_KEY = "d6ea3b8e81ac4026af1150822231801"
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.bGet.setOnClickListener{
            getResult("Almaty")
        }
    }
    private fun getResult (name: String) {
        val url = "https://api.weatherapi.com/v1/current.json" +
                "?key=$API_KEY&q=$name&aqi=no"
        val queue = Volley.newRequestQueue(this)
        val stringRequest = StringRequest(
            Request.Method.GET,
            url,
            {
                    response ->
                val obj = JSONObject(response)
                val temperature = obj.getJSONObject("current")
                Log.d("MyLog", "Response: ${temperature.getString("temp_c")}")
            },
            {
                Log.d("MyLog", "Volley error: $it")
            }
            )
        queue.add(stringRequest)
    }
}
