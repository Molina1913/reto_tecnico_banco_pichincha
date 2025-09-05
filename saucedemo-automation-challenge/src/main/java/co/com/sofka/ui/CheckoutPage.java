package co.com.sofka.ui;

import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.findby.By;

public class CheckoutPage {
    public static final Target FIRST_NAME_INPUT = Target
            .the("First name input").located(By.id("first-name"));
    public static final Target LAST_NAME_INPUT = Target
            .the("Last name input").located(By.id("last-name"));
    public static final Target POSTAL_CODE_INPUT = Target
            .the("Postal code input").located(By.id("postal-code"));
    public static final Target CONTINUE_BUTTON = Target
            .the("Continue button").located(By.xpath("//input[@value='CONTINUE']"));
    public static final Target FINISH_BUTTON = Target
            .the("Finish button").located(By.xpath("//a[contains(text(), 'FINISH')]"));
}
