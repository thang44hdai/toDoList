package com.example.app

import android.content.ContentValues
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.app.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {
    private lateinit var binding: ActivityMain2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate((layoutInflater))
        setContentView(binding.root)

        binding.btnBack.setOnClickListener()
        {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        // set database
        // ContentValues()
        var helper = SqliteHelper(applicationContext)
        var db = helper.readableDatabase

        binding.btnSave.setOnClickListener()
        {
            var cv = ContentValues()
            cv.put("name", binding.edtInput.text.toString())
            db.insert("users", null, cv)
            Toast.makeText(applicationContext,"ok", Toast.LENGTH_SHORT).show()
            finish()
        }

    }
}