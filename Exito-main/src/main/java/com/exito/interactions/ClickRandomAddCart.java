package com.exito.interactions;

import com.exito.utils.EscrituraExcel;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.actions.Scroll;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Random;

import static com.exito.ui.ProductsCatalogUI.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class ClickRandomAddCart implements Interaction {

    private WebElementFacade element;
    private WebElementFacade name;

    @Override
    public <T extends Actor> void performAs(T actor) {
        List<WebElementFacade> listProducts = BTN_ADD_CART.resolveAllFor(actor);
        List<WebElementFacade> listNames = LBL_PRODUCT_NAME.resolveAllFor(actor);

        if (listProducts.size() >= 5) {
            Random random = new Random();
            int indexRandom = random.nextInt(listProducts.size() - 2);

            element = listProducts.get(indexRandom);
            name = listNames.get(indexRandom);

            WebDriverWait wait = new WebDriverWait(Serenity.getDriver(), Duration.ofSeconds(10));
            wait.until(ExpectedConditions.elementToBeClickable(element));

            Scroll.to(element);

            element.click();
            EscrituraExcel.escrituraExcel(
                    "src/main/resources/Data/Data.xlsx",
                    name.getText(), 1, 1);

            for (int i = 0; i < 4; i++) {
                element = listProducts.get(indexRandom + i + 1);
                name = listNames.get(indexRandom + i + 1);

                wait.until(ExpectedConditions.elementToBeClickable(element));

                Scroll.to(element);

                element.click();
                EscrituraExcel.escrituraExcel(
                        "src/main/resources/Data/Data.xlsx",
                        name.getText(), i + 2, 1);
            }
        }

    }

    public static Performable click(){
        return instrumented(ClickRandomAddCart.class);
    }

}
