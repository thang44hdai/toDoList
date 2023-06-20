package com.example.app

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.ContentValues
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.app.databinding.ActivityMain2Binding
import java.util.Date

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
            var rs = db.rawQuery("SELECT * FROM users", null)
            var cv = ContentValues()
            if(!rs.moveToLast())
                cv.put("id", 1)
            else
                cv.put("id", rs.getString(0).toInt()+1)
            cv.put("name", binding.edtInput.text.toString())
            cv.put("date", binding.tvDate.text.toString())
            db.insert("users", null, cv)
            db.close()
            Toast.makeText(applicationContext,"Đã lưu", Toast.LENGTH_SHORT).show()
            finish()
        }

        binding.btnDelete.setOnClickListener()
        {
            val selection = "id = ?"
            val selectionArgs = arrayOf(binding.edtDelete.text.toString())
            db.delete("users", selection, selectionArgs)
            finish()
        }
        binding.btnDate.setOnClickListener()
        {
            DatePickerDialog(this, DatePickerDialog.OnDateSetListener{
                datePicker, i, i2, i3 ->  binding.tvDate.setText("$i3 / ${i2 + 1} / $i")
            },2022, 1, 1).show()
            Toast.makeText(this, "okeee", Toast.LENGTH_SHORT).show()
        }

    }
}