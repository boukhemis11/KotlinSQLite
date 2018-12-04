package com.app.boukh.kotlinsqlite.model

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DBHelper(context: Context):SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VER) {

    private val TABLE_NAME = "Person"
    private val COL_ID = "Id"
    private val COL_NAME = "Name"
    private val COL_EMAIL = "Email"

    private val CREATE_TABLE = """
CREATE TABLE $TABLE_NAME (
$COL_ID INTEGER PRIMARY KEY,
$COL_NAME TEXT,
$COL_EMAIL TEXT
)
"""

    companion object {
        private val DATABASE_VER = 1
        private val DATABASE_NAME = "boukhemis.db"
    }

    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL(CREATE_TABLE)

    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")
        onCreate(db)
    }


}