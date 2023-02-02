package com.example.rentallaptop

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.example.pertemuan8.SharePrefHelper

class Profile : AppCompatActivity(), View.OnClickListener {

    var mySQLitedb : myDBHelper? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
        mySQLitedb = myDBHelper(this)





        val btn_find:Button = findViewById(R.id.btn_find)
        val btn_submit:Button = findViewById(R.id.btn_submit)
        val btn_reset:Button = findViewById(R.id.btn_reset)


        btn_submit.setOnClickListener(this)
        btn_find.setOnClickListener(this)
        btn_reset.setOnClickListener(this)


    }


    override fun onClick(p0: View?) {
        TODO("Not yet implemented")



    }

}
