package com.dst511s.dst_skillconnect.data.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class JobPreferences(
    val desiredRoles: List<String> = emptyList(),
    val desiredIndustries: List<String> = emptyList(),
    val desiredLocations: List<String> = emptyList(),
    val remotePreference: RemotePreference = RemotePreference.NO_PREFERENCE,
    val employmentTypes: List<EmploymentType> = emptyList(),
    val minSalary: Double? = null,
    val currency: String = "USD",
    val isAvailableForWork: Boolean = true,
    val availabilityDate: Long? = null
) : Parcelable
