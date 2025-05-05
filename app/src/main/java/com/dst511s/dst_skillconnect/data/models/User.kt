package com.dst511s.dst_skillconnect.data.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class User(
    val id: String = "",
    val email: String = "",
    val fullName: String = "",
    val userType: UserType = UserType.JOB_SEEKER,
    val profilePhotoUrl: String? = null,
    val location: String = "",
    val bio: String = "",
    val profileCompletionPercentage: Int = 0,
    val createdAt: Long = 0,
    val updatedAt: Long = 0
) : Parcelable
