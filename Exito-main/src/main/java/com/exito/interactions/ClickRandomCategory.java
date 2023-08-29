package com.exito.interactions;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Performable;

import java.util.List;
import java.util.Random;

import static com.exito.ui.HomeUI.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class ClickRandomCategory implements Interaction {
    private WebElementFacade element;

    @Override
    public <T extends Actor> void performAs(T actor) {
        List<WebElementFacade> listProducts = LNK_CATEGORY.resolveAllFor(actor);
        Random random= new Random();
        int indexRandom= random.nextInt(listProducts.size());
        element=listProducts.get(indexRandom);
        listProducts.get(indexRandom).click();
    }

    public static Performable click(){
        return instrumented(ClickRandomCategory.class);
    }
}
