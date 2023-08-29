package com.exito.ui;

import net.serenitybdd.screenplay.targets.Target;

public class ProductsCatalogUI {

    public static Target BTN_ADD_CART=Target.the("Button add cart")
            .locatedBy("//button[@class='vtex-button bw1 ba fw5 v-mid relative pa0 lh-solid br2 min-h-regular t-action bg-action-primary b--action-primary c-on-action-primary hover-bg-action-primary hover-b--action-primary hover-c-on-action-primary pointer w-100 ']");

    public static Target LBL_PRODUCT_NAME=Target.the("Label product name")
            .locatedBy("//span[@class='vtex-store-components-3-x-productBrand ']");

    public static Target LNK_CART=Target.the("Link add cart")
            .locatedBy("//a[@class='exito-header-3-x-minicartLink']");

    public static Target BTN_QUANTITY=Target.the("Button queantity")
            .locatedBy("//button[@class='exito-vtex-components-4-x-buttonActions exito-vtex-components-4-x-productSummaryAddToCar  product-summary-add-to-car-plus']");

    public static Target LBL_QUANTITY=Target.the("Label quantity")
            .locatedBy("//div[@class='exito-vtex-components-4-x-stepperContainerQty']");

    public static Target TXT_EMAIL=Target.the("Field email")
            .locatedBy("//input[@placeholder='correo@email.com']");

    public static Target BTN_CONFIRM=Target.the("Button confirmation")
            .locatedBy("//button[@class='exito-checkout-io-0-x-preLoginActiveButton']");
}
