package com.dst511s.dst_skillconnect.unsorted.tka

import com.dst511s.dst_skillconnect.unsorted.data.Message
import com.dst511s.dst_skillconnect.unsorted.enume.MessageType

private fun getMessagePreview(message: Message): String {
    return when (message.type) {
        MessageType.TEXT -> message.content
        MessageType.IMAGE -> "📷 Image"
        MessageType.FILE -> "📄 File"
        MessageType.VOICE -> "🎤 Voice message"
        MessageType.JOB_SHARE -> "💼 Job opportunity"
        MessageType.WORKSHOP_INVITE -> "🎓 Workshop invitation"
        MessageType.SYSTEM -> message.content
    }
}