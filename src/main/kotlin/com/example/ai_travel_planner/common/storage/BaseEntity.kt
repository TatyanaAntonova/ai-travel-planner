package com.example.ai_travel_planner.common.storage

import jakarta.persistence.*
import java.util.*

@MappedSuperclass
abstract class BaseEntity(
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    open var id: UUID? = null
)
