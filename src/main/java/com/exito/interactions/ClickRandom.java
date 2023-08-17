package com.exito.interactions;
/*
 * @(#) CickRandom.java 11.0
 * Copyright 2023 SQA. Todos los derechos reservados.
 */

import com.exito.utils.EscrituraExcel;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.util.List;
import java.util.Random;

import static com.exito.ui.ProductCatalogUI.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

/**
 * @autor Rafael Chica
 * @Fecha: --o--
 */
public class CickRandom implements Interaction {
    private WebElementFacade element;
    @Override
    public <T extends Actor> void performAs(T actor) {
        List<WebElementFacade> listProducts = LBL_PRODUCTS.resolveAllFor(actor);

        for (int i = 0; i < 3; i++) {

            Random random= new Random();
            int indexRandom= random.nextInt(listProducts.size());

            EscrituraExcel.escrituraExcel(
                    "src/main/resources/Data/Data.xlsx",
                    listProducts.get(indexRandom).getText(),i+1,i+1);

            List<WebElementFacade> listButtonAdd = BTN_ADD_CAR.resolveAllFor(actor);
            listButtonAdd.get(indexRandom).click();

            WaitUntil.the(BTN_ADD_QUANTITY, isVisible()).forNoMoreThan(10).seconds();
            List<WebElementFacade> listQuatity = BTN_ADD_QUANTITY.resolveAllFor(actor);
            Random rand= new Random();
            Integer indexRan= rand.nextInt(3);

            for (int j = 0; j < indexRan; j++) {
                listQuatity.get(i).click();
            }

            EscrituraExcel.escrituraExcel(
                    "src/main/resources/Data/Data.xlsx",
                    indexRan.toString(),2+i,2+i);
        }

        
    }

    public static Performable click(){
        return instrumented(CickRandom.class);
    }

    public WebElementFacade getElement() {
        return element;
    }
}
