package com.dst511s.dst_skillconnect.unsorted.data

data class LearningPath(
    val id: String,
    val title: String,
    val description: String,
    val targetRole: String,
    val difficulty: PathDifficulty,
    val estimatedDuration: String,
    val totalLessons: Int,
    val completedLessons: Int,
    val skills: List<String>,
    val prerequisites: List<String>,
    val modules: List<LearningModule>,
    val progress: Float, // 0.0 to 1.0
    val isEnrolled: Boolean,
    val enrollmentDate: Long?,
    val lastAccessed: Long?,
    val category: LearningCategory,
    val rating: Float,
    val reviewCount: Int,
    val author: PathAuthor,
    val price: PathPrice,
    val certificate: CertificateInfo?
)