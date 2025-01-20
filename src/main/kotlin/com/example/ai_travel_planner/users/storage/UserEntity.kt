package com.example.ai_travel_planner.users.storage

import com.example.ai_travel_planner.common.storage.BaseEntity
import jakarta.persistence.*

@Entity
@Table(name = "users")
class UserEntity(
    @Column(name = "first_name")
    var firstName: String = "",

    @Column(name = "last_name")
    var lastName: String = "",

    @Column(name = "email")
    var email: String = "",

    @Column(name = "password_hash")
    var passwordHash: String = ""
) : BaseEntity()
