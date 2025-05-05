package com.dst511s.dst_skillconnect.data.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Education(
    val id: String = "",
    val institution: String = "",
    val degree: String = "",
    val fieldOfStudy: String = "",
    val startDate: Long = 0,
    val endDate: Long? = null,
    val isCurrentlyStudying: Boolean = false,
    val description: String = ""
) : Parcelable
