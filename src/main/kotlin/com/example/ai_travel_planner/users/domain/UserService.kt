package com.example.ai_travel_planner.users.domain

import com.example.ai_travel_planner.users.storage.UserEntity
import com.example.ai_travel_planner.users.storage.UserRepository
import com.example.ai_travel_planner.users.storage.UserRoleEntity
import com.example.ai_travel_planner.users.storage.UserRoleRepository
import org.springframework.stereotype.Service

interface UserService {
    fun getByEmail(email: String): User?
}

@Service
class UserServiceImpl(
    private val userRepository: UserRepository,
    private val userRoleRepository: UserRoleRepository
) : UserService {

    override fun getByEmail(email: String): User? {
        return userRepository.findByEmail(email)?.let {
            userRoleRepository.findByUserId(it.id!!)
                ?.let { role -> it.toUser(listOf(role)) }
        }
    }

    private fun UserEntity.toUser(roles: List<UserRoleEntity>): User {
        return User(
            id = id!!,
            email = email,
            firstName = firstName,
            lastName = lastName,
            roles = roles.map { it.roleName },
        )
    }
}
