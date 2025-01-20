package com.example.ai_travel_planner.users.storage

import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface UserRoleRepository : JpaRepository<UserRoleEntity, UUID> {
    fun findByUserId(userId: UUID): UserRoleEntity?
}
