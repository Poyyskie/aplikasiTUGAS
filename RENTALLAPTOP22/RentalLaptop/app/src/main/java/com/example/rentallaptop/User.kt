package com.example.rentallaptop

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize
class User :Parcelable {
    var id :Int = 0
    var nama : String =""
    var email : String=""
    var nohp : String =""
    var username : String =""
    var password : String =""
}