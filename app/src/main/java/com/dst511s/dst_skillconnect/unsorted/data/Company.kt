package com.dst511s.dst_skillconnect.unsorted.data

import android.os.Parcelable
import com.dst511s.dst_skillconnect.unsorted.enume.CompanySize
import kotlinx.parcelize.Parcelize

@Parcelize
data class Company(
    val id: String = "",
    val name: String = "",
    val description: String = "",
    val website: String = "",
    val industry: String = "",
    val size: CompanySize = CompanySize.SMALL,
    val foundedYear: Int? = null,
    val headquarters: String = "",
    val logoUrl: String = "",
    val socialLinks: Map<String, String> = emptyMap(),
    val createdAt: Long = 0,
    val updatedAt: Long = 0
) : Parcelable
