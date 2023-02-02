package com.example.rentallaptop

import MyDB.userDB
import MyDB.userDB.userTable.*
import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.SQLException
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class myDBHelper(context: Context) : SQLiteOpenHelper(
    context, DATABASE_NAME, null, DATABASE_VERSION
) {
    companion object{
        private val DATABASE_NAME ="mysqlitedb.db"
        private val DATABASE_VERSION = 1
    }

    override fun onCreate(db: SQLiteDatabase?) {
        var CREATE_USER_TABLE ="CREATE TABLE ${userDB.userTable.TABLE_USER}" +
                "(${userDB.userTable.COLUMN_ID} INTEGER PRIMARY KEY," +
                "${userDB.userTable.COLUMN_NAME} TEXT," +
                "${userDB.userTable.COLUMN_EMAIL} TEXT," +
                "${userDB.userTable.COLUMN_PHONE} INTEGER PRIMARY KEY," +
                "${userDB.userTable.COLUMN_USERNAME} TEXT," +
                "${userDB.userTable.COLUMN_PASSWORD} TEXT)"
        db?.execSQL(CREATE_USER_TABLE)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("DROP TABLE IF EXISTS ${userDB.userTable.TABLE_USER}")
        onCreate(db)
    }
    fun addUser(User: User) : Long{
        var db = this.writableDatabase
        var contentValues = ContentValues().apply {
            put(userDB.userTable.COLUMN_NAME, User.nama)
            put(userDB.userTable.COLUMN_EMAIL,User.email)
            put(userDB.userTable.COLUMN_PHONE,User.nohp)
            put(userDB.userTable.COLUMN_USERNAME,User.username)
            put(userDB.userTable.COLUMN_PASSWORD,User.password)
        }
        var success = db.insert(userDB.userTable.TABLE_USER,null, contentValues)
        db.close()
        return success
    }



    @SuppressLint("Range")
    fun viewAllName() : List<String>{
        val nameList = ArrayList<String>()
        val SELECT_NAME = "SELECT ${userDB.userTable.COLUMN_NAME} FROM " +
                "${userDB.userTable.TABLE_USER}"
        var db = this.readableDatabase
        var cursor : Cursor?=null
        try {
            cursor = db.rawQuery(SELECT_NAME, null )
        }catch (e : SQLException){
            return ArrayList()
        }
        var username = ""
        if (cursor.moveToFirst()){
            do{
                username = cursor.getString(cursor.getColumnIndex(userDB.userTable.COLUMN_NAME))
                nameList.add(username)
            }while (cursor.moveToNext())
        }
        return nameList
    }

    fun deleteUser(nama : String){
        var db = this.writableDatabase
        var selection="${userDB.userTable.COLUMN_NAME} = ?"
        var selectionArgs = arrayOf(nama)
        db.delete(userDB.userTable.TABLE_USER, selection,selectionArgs)
    }
}