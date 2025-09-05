package co.com.sofka.tasks.ui;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;

import static co.com.sofka.ui.LoginPage.PASSWORD_INPUT;

public class EnterPassword implements Task {
    String password;

    public EnterPassword withPassword(String password) {
        this.password = password;
        return this;
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(password).into(PASSWORD_INPUT)
        );
    }

    public static EnterPassword enterPassword() {
        return new EnterPassword();
    }
}
