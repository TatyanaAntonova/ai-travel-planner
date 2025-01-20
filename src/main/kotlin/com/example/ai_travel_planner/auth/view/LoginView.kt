package com.example.ai_travel_planner.auth.view

import com.example.ai_travel_planner.layout.MainLayout
import com.github.mvysny.karibudsl.v10.KComposite
import com.github.mvysny.karibudsl.v10.loginForm
import com.github.mvysny.karibudsl.v10.verticalLayout
import com.vaadin.flow.component.login.LoginForm
import com.vaadin.flow.component.orderedlayout.FlexComponent
import com.vaadin.flow.router.BeforeEnterEvent
import com.vaadin.flow.router.BeforeEnterObserver
import com.vaadin.flow.router.PageTitle
import com.vaadin.flow.router.Route
import com.vaadin.flow.server.auth.AnonymousAllowed

@Route("login", layout = MainLayout::class)
@PageTitle("Login | Liner Legal CRM")
@AnonymousAllowed
class LoginView : KComposite(), BeforeEnterObserver {
    private lateinit var login: LoginForm

    init {
        ui {
            verticalLayout {
                className = "login-view"
                setSizeFull()
                justifyContentMode = FlexComponent.JustifyContentMode.CENTER
                alignItems = FlexComponent.Alignment.CENTER
                login = loginForm {
                    action = "login"
                    isForgotPasswordButtonVisible = false
                }

            }
        }
    }

    override fun beforeEnter(beforeEnterEvent: BeforeEnterEvent) {
        if (beforeEnterEvent.location
                .queryParameters
                .parameters
                .containsKey("error")
        ) {
            login.isError = true
        }
    }

}
