package com.example.weatherapp2
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.weatherapp2.fragments.MainFragment

const val API_KEY = "d6ea3b8e81ac4026af1150822231801"

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.placeHolder, MainFragment.newInstance())
            .commit()
    }
}
