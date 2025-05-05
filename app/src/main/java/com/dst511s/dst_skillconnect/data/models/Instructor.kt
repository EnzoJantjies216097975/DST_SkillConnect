package com.dst511s.dst_skillconnect.data.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Instructor(
    val id: String = "",
    val name: String = "",
    val bio: String = "",
    val imageUrl: String = ""
) : Parcelable
