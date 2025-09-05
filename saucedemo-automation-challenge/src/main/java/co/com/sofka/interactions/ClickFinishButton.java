package co.com.sofka.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Click;

import static co.com.sofka.ui.CheckoutPage.FINISH_BUTTON;

public class ClickFinishButton implements Interaction {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(FINISH_BUTTON)
        );
    }

    public static ClickFinishButton clickFinishButton() {
        return new ClickFinishButton();
    }
}
