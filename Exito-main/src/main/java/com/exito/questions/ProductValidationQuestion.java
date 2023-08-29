package com.exito.questions;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import com.exito.utils.Data;

import java.util.List;

import static com.exito.ui.ProductValidationUI.LBL_NAME_CART;
import static com.exito.ui.ProductValidationUI.LBL_QUANTITY;

public class ProductValidationQuestion implements Question<Boolean> {
    @Override
    public Boolean answeredBy(Actor actor) {
        List<WebElementFacade> listProducts = LBL_NAME_CART.resolveAllFor(actor);
        List<WebElementFacade> listQuantity = LBL_QUANTITY.resolveAllFor(actor);

        for (int i = 0; i < 5; i++) {
            String validationText = Data.extractTo().get(i).get("Nombre");
            String validationQty = Data.extractTo().get(i).get("Cantidad");

            String qtyProduct = listQuantity.get(i).getText().toString();
            String nameProduct = listProducts.get(i).getText().toString();

            if (!validationText.contains(nameProduct) && !validationQty.contains(qtyProduct)) {
                return false;
            }
        }

        return true;
    }

    public static Question<Boolean> from(){
        return new ProductValidationQuestion();
    }
}
