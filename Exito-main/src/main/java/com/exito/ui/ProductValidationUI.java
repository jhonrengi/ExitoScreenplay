package com.exito.ui;

import net.serenitybdd.screenplay.targets.Target;

public class ProductValidationUI {

    public static Target LBL_NAME_CART=Target.the("Label name product in cart")
            .locatedBy("//span[@data-molecule-product-detail-name-span='true']");

    public static Target LBL_QUANTITY=Target.the("Label quantity product in cart")
            .locatedBy("//span[@data-molecule-quantity-und-value='true']");

}
