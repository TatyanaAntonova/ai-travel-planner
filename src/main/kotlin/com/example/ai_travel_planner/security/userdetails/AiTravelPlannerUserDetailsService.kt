package com.example.ai_travel_planner.security.userdetails

import com.example.ai_travel_planner.users.UserRole
import com.example.ai_travel_planner.users.credentials.UserCredentialsService
import com.example.ai_travel_planner.users.domain.UserService
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service

@Service
class AiTravelPlannerUserDetailsService(
    private val userService: UserService,
    private val userCredentialsService: UserCredentialsService
) : UserDetailsService {

    override fun loadUserByUsername(email: String?): UserDetails {
        return email
            ?.let { userService.getByEmail(email) }
            ?.let { user -> userCredentialsService.getUserCredentials(email)?.let { it to user } }
            ?.let { (userCredentials, user) ->
                AiTravelPlannerUserDetails(
                    id = user.id,
                    email = userCredentials.email,
                    password = userCredentials.passwordHash,
                    active = true,
                    firstName = user.firstName,
                    lastName = user.lastName,
                    authorities = user.roles.toGrantedAuthorities()
                )
            }
            ?: throw UsernameNotFoundException("No user found with username '$email'.")
    }

    private fun List<UserRole>.toGrantedAuthorities(): MutableCollection<GrantedAuthority> {
        return map { SimpleGrantedAuthority("ROLE_${it.name}") }.toMutableList()
    }
}
