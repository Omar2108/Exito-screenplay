package com.exito.interactions;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import com.exito.utils.Data;
import static com.exito.ui.CarProductUI.*;
import static com.exito.ui.HomeUI.TXT_SEARCH;
import static com.exito.ui.ProductCatalogUI.LINK_CAR_PRODUCT;
import static net.serenitybdd.screenplay.Tasks.instrumented;


public class ClickButtonCar implements Interaction {
    @Override
    public <T extends Actor> void performAs(T actor) {
       WebElementFacade btnCar = LINK_CAR_PRODUCT.resolveFor(actor);
       btnCar.click();
        if (TXT_EMAIL.resolveFor(actor).isDisplayed()){
            Enter.theValue(Data.extractTo().get(0).get("Email")).into(TXT_SEARCH);
            Click.on(BTN_EMAIL_CONFIRM);

        }

    }

    public static Performable click(){
        return instrumented(ClickButtonCar.class);
    }
}
