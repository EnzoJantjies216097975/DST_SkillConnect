package com.dst511s.dst_skillconnect.data.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ApplicationNote(
    val id: String = "",
    val content: String = "",
    val createdBy: String = "",
    val createdAt: Long = 0,
    val isPrivate: Boolean = true
) : Parcelable
