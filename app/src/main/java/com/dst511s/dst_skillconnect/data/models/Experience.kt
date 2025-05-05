package com.dst511s.dst_skillconnect.data.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Experience(
    val id: String = "",
    val company: String = "",
    val position: String = "",
    val location: String = "",
    val startDate: Long = 0,
    val endDate: Long? = null,
    val isCurrentPosition: Boolean = false,
    val description: String = "",
    val skills: List<String> = emptyList(),
    val role: String,
    val period: String,
    val isCurrentRole: Boolean
) : Parcelable
