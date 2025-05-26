package com.dst511s.dst_skillconnect.unsorted.data

import com.dst511s.dst_skillconnect.unsorted.enume.BenefitCategory

data class CompanyBenefit(
    val category: BenefitCategory,
    val title: String,
    val description: String,
    val icon: String
)