package com.exito.interactions;

import com.exito.utils.EscrituraExcel;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import java.util.List;
import java.util.Random;

import static com.exito.ui.ProductsCatalogUI.BTN_QUANTITY;
import static com.exito.ui.ProductsCatalogUI.LBL_QUANTITY;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class RandomQuantity implements Interaction {
    private WebElementFacade element;
    @Override
    public <T extends Actor> void performAs(T actor) {
        List<WebElementFacade> quantity = BTN_QUANTITY.resolveAllFor(actor);
        List<WebElementFacade> lblQty = LBL_QUANTITY.resolveAllFor(actor);

        WebDriver driver = BrowseTheWeb.as(actor).getDriver();
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;

        for (int i = 0; i < 9; i++) {
            element = quantity.get(i);
            Random random = new Random();
            int randomNumber = random.nextInt(9) + 1;

            for (int j = 0; j < randomNumber; j++) {
                jsExecutor.executeScript("window.scrollTo(0, 0);", element);
                element.click();
            }

            EscrituraExcel.escrituraExcel(
                    "src/main/resources/Data/Data.xlsx",
                    lblQty.get(i).getText(),i+1,2);
        }
    }

    public static Performable click(){
        return instrumented(RandomQuantity.class);
    }
}
