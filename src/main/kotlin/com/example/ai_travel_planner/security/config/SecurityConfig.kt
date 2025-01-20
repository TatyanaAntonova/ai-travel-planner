package com.example.ai_travel_planner.security.config

import com.example.ai_travel_planner.auth.view.LoginView
import com.vaadin.flow.spring.security.VaadinWebSecurity
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.web.util.matcher.AntPathRequestMatcher

@Configuration
@EnableWebSecurity
class SecurityConfig : VaadinWebSecurity() {

    override fun configure(http: HttpSecurity) {
        http.authorizeHttpRequests { auth ->
            auth.requestMatchers(AntPathRequestMatcher("/public/**"))
                .permitAll()
        }

        setLoginView(http, LoginView::class.java)
        super.configure(http)
    }

}
