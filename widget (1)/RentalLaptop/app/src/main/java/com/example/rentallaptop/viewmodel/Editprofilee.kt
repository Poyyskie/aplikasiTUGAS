package com.example.rentallaptop.viewmodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import com.example.rentallaptop.R
import com.example.rentallaptop.user
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class Editprofilee : AppCompatActivity() {
    var mysqlitedb : myDBHelper? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_database)
        mysqlitedb = myDBHelper(this)

        var btn_submit : Button = findViewById(R.id.btn_submit)
        btn_submit.setOnClickListener {
            val userTmp = user()
            var edit_text_name : EditText = findViewById(R.id.edit_text_name)
            var edit_text_email : EditText = findViewById(R.id.edit_text_email)
            var edit_text_phone_number : EditText = findViewById(R.id.edit_text_phone_number)
            userTmp.nama = edit_text_name.text.toString()
            userTmp.email = edit_text_email.text.toString()
            var result =mysqlitedb?.addUser(userTmp)
            if(result!=-1L){
                Toast.makeText(this, "Berhasil",Toast.LENGTH_SHORT).show()
            }
            else{
                Toast.makeText(this, "Gagal",Toast.LENGTH_SHORT).show()
            }
            updateAdapter()
            edit_text_name.text.clear()
            edit_text_email.text.clear()
            edit_text_phone_number.text.clear()

        }
        val spinner1 : Spinner = findViewById( R.id.spinner1)
        val btn_reset : Button = findViewById(R.id.btn_submit)
        btn_submit.setOnClickListener {
            var nama = spinner1.selectedItem.toString()
            if(nama!=null || nama !=""){
                doAsync {
                    mysqlitedb?.deleteData(nama)
                    updateAdapter()
                }
            }
        }
    }

    private fun updateAdapter() {
        doAsync {
            var nameList = mysqlitedb?.viewAllName()?.toTypedArray()
            val spinner1 : Spinner = findViewById( R.id.spinner1)
            uiThread {
                if(spinner1 != null && nameList?.size != 0) {
                    var arrayAdapter = ArrayAdapter(applicationContext,
                        android.R.layout.simple_spinner_dropdown_item, nameList!!)
                    spinner1.adapter = arrayAdapter
                }
            }
        }
    }


}