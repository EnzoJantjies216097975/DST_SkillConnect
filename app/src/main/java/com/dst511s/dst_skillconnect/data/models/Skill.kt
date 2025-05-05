package com.dst511s.dst_skillconnect.data.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Skill(
    val id: String = "",
    val name: String = "",
    val level: Boolean = SkillLevel.BEGINNER,
    val isVerified: Boolean = false,
    val verificationDate: Long? = null,
    val category: String = ""
) : Parcelable
