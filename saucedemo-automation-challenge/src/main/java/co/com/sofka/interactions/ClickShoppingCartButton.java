package co.com.sofka.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Click;

import static co.com.sofka.ui.HomePage.SHOPPING_CART;

public class ClickShoppingCartButton implements Interaction {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(SHOPPING_CART)
        );
    }

    public static ClickShoppingCartButton clickShoppingCartButton() {
        return new ClickShoppingCartButton();
    }
}
