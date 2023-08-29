package com.exito.tasks;

import com.exito.interactions.ClickRandomCategory;
import com.exito.interactions.ClickRandomSubCat;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static com.exito.ui.HomeUI.BTN_CATEGORYS;
import static com.exito.ui.HomeUI.LNK_SUB_CATEGORYS;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class HomeTask implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(BTN_CATEGORYS, isVisible()).forNoMoreThan(10).seconds(),
                Click.on(BTN_CATEGORYS),
                ClickRandomCategory.click(),
                WaitUntil.the(LNK_SUB_CATEGORYS, isVisible()).forNoMoreThan(5).seconds(),
                ClickRandomSubCat.click()
        );
    }

    public static HomeTask on(){
        return  instrumented(HomeTask.class);
    }
}
