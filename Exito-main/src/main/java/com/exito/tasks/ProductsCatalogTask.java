package com.exito.tasks;

import com.exito.interactions.ClickRandomAddCart;
import com.exito.interactions.RandomQuantity;
import com.exito.utils.Data;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.Keys;

import static com.exito.ui.ProductsCatalogUI.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;


public class ProductsCatalogTask implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                ClickRandomAddCart.click(),
                WaitUntil.the(BTN_QUANTITY, isClickable()).forNoMoreThan(7).seconds(),
                RandomQuantity.click(),
                Click.on(LNK_CART),
                WaitUntil.the(TXT_EMAIL, isVisible()).forNoMoreThan(15).seconds(),
                Enter.theValue(Data.extractTo().get(0).get("Correo")).into(TXT_EMAIL),
                Click.on(BTN_CONFIRM)
        );
    }

    public static ProductsCatalogTask on(){
        return instrumented(ProductsCatalogTask.class);
    }
}
