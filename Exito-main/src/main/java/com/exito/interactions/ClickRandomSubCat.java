package com.exito.interactions;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Performable;

import java.util.List;
import java.util.Random;

import static com.exito.ui.HomeUI.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class ClickRandomSubCat implements Interaction {

    private WebElementFacade element;

    @Override
    public <T extends Actor> void performAs(T actor) {
        List<WebElementFacade> listProducts = LNK_SUB_CATEGORYS.resolveAllFor(actor);
        List<WebElementFacade> firstFiveElements = listProducts.subList(0, Math.min(5, listProducts.size()));

        Random random= new Random();
        int indexRandom= random.nextInt(firstFiveElements.size());

        element=firstFiveElements.get(indexRandom);
        element.click();
    }

    public static Performable click(){
        return instrumented(ClickRandomSubCat.class);
    }

}
