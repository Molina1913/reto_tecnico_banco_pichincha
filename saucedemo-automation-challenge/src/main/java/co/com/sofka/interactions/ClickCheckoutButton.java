package co.com.sofka.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Click;

import static co.com.sofka.ui.ShoppingCartPage.CHECKOUT_BUTTON;

public class ClickCheckoutButton implements Interaction {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(CHECKOUT_BUTTON)
        );
    }

    public static ClickCheckoutButton clickCheckoutButton() {
        return new ClickCheckoutButton();
    }
}
