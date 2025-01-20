package com.example.ai_travel_planner.home

import com.example.ai_travel_planner.layout.MainLayout
import com.vaadin.flow.component.ClickEvent
import com.vaadin.flow.component.Key
import com.vaadin.flow.component.button.Button
import com.vaadin.flow.component.button.ButtonVariant
import com.vaadin.flow.component.html.Paragraph
import com.vaadin.flow.component.orderedlayout.VerticalLayout
import com.vaadin.flow.component.textfield.TextField
import com.vaadin.flow.router.Route
import jakarta.annotation.security.PermitAll

@Route(value = "", layout = MainLayout::class)
@PermitAll
class MainView : VerticalLayout() {
    init {

        val textField = TextField("Your name")
        textField.addClassName("bordered")

        val button = Button(
            "Say hello"
        ) { _: ClickEvent<Button?>? ->
            add(Paragraph("Hello ${textField.value}"))
        }

        button.addThemeVariants(ButtonVariant.LUMO_PRIMARY)
        button.addClickShortcut(Key.ENTER)
        addClassName("centered-content")
        add(textField, button)
    }
}
