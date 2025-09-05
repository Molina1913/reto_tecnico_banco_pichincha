package co.com.sofka.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;

import static co.com.sofka.ui.LoginPage.USERNAME_INPUT;

public class EnterUserName implements Task {
    String username;

    public EnterUserName withUsername(String username) {
        this.username = username;
        return this;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(username).into(USERNAME_INPUT)
        );
    }

    public static EnterUserName enterUserName() {
        return new EnterUserName();
    }
}
