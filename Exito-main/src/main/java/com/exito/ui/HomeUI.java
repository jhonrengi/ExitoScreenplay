package com.exito.ui;

import net.serenitybdd.screenplay.targets.Target;

public class HomeUI {

    public static Target BTN_CATEGORYS=Target.the("Button categories")
            .locatedBy("//button[@type='button']");

    public static Target LNK_CATEGORY=Target.the("Link categories")
            .locatedBy("//li[@id='undefined-nivel2-Electrodomésticos' or @id='undefined-nivel2-Libros y papelería' or @id='undefined-nivel2-Juguetería']");

    public static Target LNK_SUB_CATEGORYS=Target.the("Link sub-categories")
            .locatedBy("//a[contains(@id,'Categorías-nivel2-')]");
}
