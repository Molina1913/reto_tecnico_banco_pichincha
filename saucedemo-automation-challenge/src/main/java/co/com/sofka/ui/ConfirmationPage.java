package co.com.sofka.ui;

import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.findby.By;

public class ConfirmationPage {
    public static final Target CONFIRMATION_MESSAGE = Target
            .the("Confirmation message").located(By.xpath("//h2[contains(text(), 'THANK YOU FOR YOUR ORDER')]"));
}
