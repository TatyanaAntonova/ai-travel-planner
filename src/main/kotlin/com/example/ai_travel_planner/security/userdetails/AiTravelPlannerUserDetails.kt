package com.example.ai_travel_planner.security.userdetails

import com.example.ai_travel_planner.users.UserRole
import com.fasterxml.jackson.annotation.JsonIgnore
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import java.util.*

data class AiTravelPlannerUserDetails(
    @get:JsonIgnore val id: UUID,
    private val email: String,
    private val password: String,
    private val active: Boolean,
    private val firstName: String,
    private val lastName: String,
    private val authorities: MutableCollection<GrantedAuthority>
) : UserDetails {

    val userRoles = authorities.map { UserRole.roleNameMap.getValue(it.authority) }
    val displayName = "$firstName $lastName"

    override fun getAuthorities(): MutableCollection<out GrantedAuthority> {
        return authorities
    }

    override fun getPassword(): String {
        return password
    }

    override fun getUsername(): String {
        return email
    }

}
