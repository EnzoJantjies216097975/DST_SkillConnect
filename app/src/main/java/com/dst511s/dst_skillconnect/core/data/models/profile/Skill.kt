package com.dst511s.dst_skillconnect.core.data.models.profile

import android.os.Parcelable
import com.dst511s.dst_skillconnect.unsorted.enume.SkillLevel
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
