package com.example.app

import android.content.Intent
import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.app.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.ivavatar.setImageResource(R.drawable.ava)
        binding.btnadd.setOnClickListener()
        {
            val intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)
        }
    }

    override fun onResume() {
        var helper = SqliteHelper(applicationContext)
        val db = helper.readableDatabase
        var rs = db.rawQuery("SELECT * FROM users", null)
        //
        var ds = ArrayList<data>()
        if(rs.moveToLast())
            ds.add(data(rs.getString(1).toString(), "a2s"))
        val adapter = adapter(ds)
        binding.lvItem.adapter = adapter
        binding.lvItem.layoutManager = LinearLayoutManager(
            this,
            LinearLayoutManager.VERTICAL,
            false
        )
        super.onResume()
    }
}