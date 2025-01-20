package com.example.ai_travel_planner.users.domain

import com.example.ai_travel_planner.users.UserRole
import java.util.*

data class User(
    val id: UUID,
    val email: String,
    val firstName: String,
    val lastName: String,
    val roles: List<UserRole>
)
