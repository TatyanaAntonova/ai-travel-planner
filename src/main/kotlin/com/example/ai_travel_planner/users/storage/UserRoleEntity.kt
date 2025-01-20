package com.example.ai_travel_planner.users.storage

import com.example.ai_travel_planner.common.storage.BaseEntity
import com.example.ai_travel_planner.users.UserRole
import jakarta.persistence.*
import java.util.*

@Entity
@Table(name = "user_roles")
class UserRoleEntity(
    @Column(name = "role_name")
    @Enumerated(EnumType.STRING)
    var roleName: UserRole = UserRole.USER,

    @Column(name = "user_id")
    var userId: UUID = UUID.randomUUID()
) : BaseEntity()
