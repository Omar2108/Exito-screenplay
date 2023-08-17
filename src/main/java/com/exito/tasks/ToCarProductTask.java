package com.exito.tasks;

import com.exito.interactions.ClickButtonCar;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

public class ToCarProduct implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                ClickButtonCar.click()
        );
    }
}
