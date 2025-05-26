package com.dst511s.dst_skillconnect.unsorted.tka

import com.dst511s.dst_skillconnect.unsorted.enume.NotificationType

private fun getDefaultActionText(type: NotificationType): String {
    return when (type) {
        NotificationType.JOB_MATCH -> "View Job"
        NotificationType.APPLICATION_UPDATE -> "View Application"
        NotificationType.WORKSHOP_REMINDER -> "View Workshop"
        NotificationType.SKILL_VERIFICATION -> "View Result"
        NotificationType.COMPANY_UPDATE -> "View Company"
        NotificationType.MESSAGE -> "View Message"
        NotificationType.SYSTEM_UPDATE -> "Learn More"
        NotificationType.ACHIEVEMENT -> "View Achievement"
    }
}