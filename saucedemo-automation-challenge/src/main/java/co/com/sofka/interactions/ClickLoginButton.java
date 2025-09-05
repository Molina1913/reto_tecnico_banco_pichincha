package co.com.sofka.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Click;

import static co.com.sofka.ui.LoginPage.LOGIN_BUTTON;

public class ClickLoginButton implements Interaction {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(LOGIN_BUTTON)
        );
    }

    public static ClickLoginButton clickLoginButton() {
        return new ClickLoginButton();
    }
}
