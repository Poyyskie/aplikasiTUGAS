package com.example.rentallaptop.main_ui.topup

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import androidx.core.os.bundleOf
import com.example.rentallaptop.R

class topup() : AppCompatActivity(), Parcelable {
    constructor(parcel: Parcel) : this() {
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_topup)
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {

    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<topup> {
        override fun createFromParcel(parcel: Parcel): topup {
            return topup(parcel)
        }

        override fun newArray(size: Int): Array<topup?> {
            return arrayOfNulls(size)


        }
    }
}