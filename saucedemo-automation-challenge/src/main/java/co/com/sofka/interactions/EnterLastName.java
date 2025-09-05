package co.com.sofka.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static co.com.sofka.ui.CheckoutPage.FIRST_NAME_INPUT;
import static co.com.sofka.ui.CheckoutPage.LAST_NAME_INPUT;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class EnterLastName implements Interaction {
    String lastName;

    public EnterLastName withLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(lastName).into(LAST_NAME_INPUT)
        );
    }

    public static EnterLastName enterLastName() {
        return new EnterLastName();
    }
}
