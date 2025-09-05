package co.com.sofka.ui;

import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.findby.By;

public class ShoppingCartPage {
    public static final Target CHECKOUT_BUTTON = Target
            .the("Checkout button").located(By.xpath("//a[contains(text(), 'CHECKOUT')]"));
}
