package com.dst511s.dst_skillconnect.data.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Certificate(
    val id: String = "",
    val title: String = "",
    val issuer: String = "",
    val issueDate: Long = 0,
    val expirationDate: Long? = null,
    val verificationUrl: String = "",
    val skills: List<String> = emptyList()
) : Parcelable
