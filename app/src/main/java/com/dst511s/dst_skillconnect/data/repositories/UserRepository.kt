package com.dst511s.dst_skillconnect.data.repositories

import com.dst511s.dst_skillconnect.data.models.JobSeekerProfile
import com.dst511s.dst_skillconnect.data.models.Skill
import com.dst511s.dst_skillconnect.data.models.User
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserRepository @Inject constructor(
    private val firestore: FirebaseFirestore,
    private val auth: FirebaseAuth
) {
    private val usersCollection = firestore.collection("users")
    private val jobSeekerProfilesCollection = firestore.collection("jobSeekerProfiles")

    suspend fun getCurrentUser(): User? {
        val currentUserId = auth.currentUser?.uid ?: return null
        return getUserById(currentUserId)
    }

    suspend fun getUserById(userId: String): User? {
        return try {
            val document = usersCollection.document(userId).get().await()
            document.toObject(User::class.java)
        } catch (e: Exception) {
            null
        }
    }

    suspend fun createUser(user: User): Boolean {
        return try {
            usersCollection.document(user.id).set(user).await()
            true
        } catch (e: Exception) {
            false
        }
    }

    suspend fun updateUser(user: User): Boolean {
        return try {
            usersCollection.document(user.id).set(user).await()
            true
        } catch (e: Exception) {
            false
        }
    }

    suspend fun getJobSeekerProfile(userId: String): JobSeekerProfile? {
        return try {
            val document = jobSeekerProfilesCollection.document(userId).get().await()
            document.toObject(JobSeekerProfile::class.java)
        } catch (e: Exception) {
            null
        }
    }

    suspend fun updateJobSeekerProfile(profile: JobSeekerProfile): Boolean {
        return try {
            jobSeekerProfilesCollection.document(profile.userId).set(profile).await()
            true
        } catch (e: Exception) {
            false
        }
    }

    suspend fun addSkill(userId: String, skill: Skill): Boolean {
        return try {
            val profile = getJobSeekerProfile(userId) ?: return false
            val updatedSkills = profile.skills.toMutableList()
            updatedSkills.add(skill)

            jobSeekerProfilesCollection.document(userId)
                .update("skills", updatedSkills)
                .await()

            true
        } catch (e: Exception) {
            false
        }
    }

    suspend fun updateSkill(userId: String, skill: Skill): Boolean {
        return try {
            val profile = getJobSeekerProfile(userId) ?: return false
            val updatedSkills = profile.skills.toMutableList()

            val index = updatedSkills.indexOfFirst { it.id == skill.id }
            if (index != -1) {
                updatedSkills[index] = skill

                jobSeekerProfilesCollection.document(userId)
                    .update("skills", updatedSkills)
                    .await()

                return true
            }

            false
        } catch (e: Exception) {
            false
        }
    }
}