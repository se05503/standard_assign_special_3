package com.example.specialassignment_3

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Flower(val id:String, val name:String, val description:String):Parcelable
