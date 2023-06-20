package com.example.app

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class SqliteHelper(context: Context): SQLiteOpenHelper(context, "USERDB", null,1) {
    override fun onCreate(p0: SQLiteDatabase?) {
        // tạo bảng
        p0?.execSQL("CREATE TABLE users (id Integer, name TEXT, date TEXT)")

    }
    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {0

    }

}