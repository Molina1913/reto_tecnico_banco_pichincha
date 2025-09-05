package co.com.sofka.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Click;

import static co.com.sofka.ui.CheckoutPage.CONTINUE_BUTTON;

public class ClickContinueButton implements Interaction {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(CONTINUE_BUTTON)
        );
    }

    public static ClickContinueButton clickContinueButton() {
        return new ClickContinueButton();
    }
}
