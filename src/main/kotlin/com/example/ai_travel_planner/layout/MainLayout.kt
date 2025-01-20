package com.example.ai_travel_planner.layout

import com.example.ai_travel_planner.security.userdetails.AiTravelPlannerUserDetails
import com.github.mvysny.karibudsl.v10.*
import com.vaadin.flow.component.orderedlayout.FlexComponent
import com.vaadin.flow.component.sidenav.SideNav
import com.vaadin.flow.component.sidenav.SideNavItem
import com.vaadin.flow.router.BeforeEnterEvent
import com.vaadin.flow.router.BeforeEnterObserver
import com.vaadin.flow.router.RouterLayout
import com.vaadin.flow.spring.security.AuthenticationContext

class MainLayout(private val authContext: AuthenticationContext) : KComposite(), RouterLayout, BeforeEnterObserver {
    init {
        ui {
            appLayout {
                if (authContext.isAuthenticated) {
                    drawer {
                        scroller {
                            content = SideNav().apply {
                                addItem(SideNavItem("FAQ"))
                            }
                        }
                    }
                }
                navbar {
                    horizontalLayout {
                        setWidthFull()
                        justifyContentMode = FlexComponent.JustifyContentMode.BETWEEN
                        alignItems = FlexComponent.Alignment.CENTER
                        isPadding = true

                        horizontalLayout {
                            if (authContext.isAuthenticated) {
                                drawerToggle()
                            }
                            h3("") { className = "logo" }
                        }

                        horizontalLayout {
                            authContext.getAuthenticatedUser(AiTravelPlannerUserDetails::class.java)
                                .map { user ->
                                    button("Logout") {
                                        onClick { authContext.logout() }
                                    }
                                }
                        }
                    }
                }
            }
        }
    }

    override fun beforeEnter(event: BeforeEnterEvent) {
        val path = event.location.path

        if (!authContext.isAuthenticated) {
            event.forwardTo("login")
            return
        }

        if (authContext.isAuthenticated && (path == "" || path == "login")) {
            event.forwardTo("")
            return
        }

        println("User is navigating to: $path")
    }

}
