package co.com.sofka.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static co.com.sofka.ui.CheckoutPage.FIRST_NAME_INPUT;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class EnterFirstName implements Interaction {
    String firstName;

    public EnterFirstName withUsername(String firstName) {
        this.firstName = firstName;
        return this;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(FIRST_NAME_INPUT, isVisible()).forNoMoreThan(10).seconds(),
                Enter.theValue(firstName).into(FIRST_NAME_INPUT)
        );
    }

    public static EnterFirstName enterFirstName() {
        return new EnterFirstName();
    }
}
