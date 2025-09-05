package co.com.sofka.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Enter;

import static co.com.sofka.ui.CheckoutPage.POSTAL_CODE_INPUT;

public class EnterPostalCode implements Interaction {
    String postalCode;

    public EnterPostalCode withNumber(String postalCode) {
        this.postalCode = postalCode;
        return this;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(postalCode).into(POSTAL_CODE_INPUT)
        );
    }

    public static EnterPostalCode enterPostalCode() {
        return new EnterPostalCode();
    }
}
