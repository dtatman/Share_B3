package com.example.share_b3

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    // Khai báo khóa cho SharedPreferences
    private val PREFS_NAME = "app_open_prefs"
    private val KEY_OPEN_COUNT = "open_count"

    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var tvOpenCount: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Ánh xạ TextView từ layout
        tvOpenCount = findViewById(R.id.tvOpenCount)

        // Thiết lập SharedPreferences
        sharedPreferences = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)

        // Lấy số lần mở ứng dụng hiện tại từ SharedPreferences
        val currentCount = getOpenCount()

        // Tăng số lần mở lên 1 và lưu lại
        val newCount = currentCount + 1
        saveOpenCount(newCount)

        // Hiển thị số lần mở ứng dụng trên màn hình
        tvOpenCount.text = "Số lần mở ứng dụng: $newCount"
    }

    // Hàm lấy số lần mở từ SharedPreferences
    private fun getOpenCount(): Int {
        return sharedPreferences.getInt(KEY_OPEN_COUNT, 0)
    }

    // Hàm lưu số lần mở vào SharedPreferences
    private fun saveOpenCount(count: Int) {
        val editor = sharedPreferences.edit()
        editor.putInt(KEY_OPEN_COUNT, count)
        editor.apply()
    }
}
