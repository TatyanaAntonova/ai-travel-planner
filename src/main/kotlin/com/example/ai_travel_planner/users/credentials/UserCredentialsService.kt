package com.example.ai_travel_planner.users.credentials

import com.example.ai_travel_planner.users.storage.UserEntity
import com.example.ai_travel_planner.users.storage.UserRepository
import org.springframework.stereotype.Service

interface UserCredentialsService {
    fun getUserCredentials(email: String): UserCredentials?
}

@Service
class UserCredentialsServiceImpl(
    private val userRepository: UserRepository
): UserCredentialsService {
    override fun getUserCredentials(email: String): UserCredentials? {
        return userRepository.findByEmail(email)?.toUserCredentials()
    }

    private fun UserEntity.toUserCredentials(): UserCredentials {
        return UserCredentials(
            id = id!!,
            email = email,
            passwordHash = passwordHash
        )
    }
}
