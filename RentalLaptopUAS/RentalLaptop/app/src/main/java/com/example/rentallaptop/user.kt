package com.example.rentallaptop

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize

class user : Parcelable {

    val id : Int = 0
    var nama : String = ""
    var email : String = ""
    val no_hp : String = ""
}
