package co.com.sofka.tasks.ui;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;

public class OpenHomePage implements Task {
    private String url;

    public OpenHomePage withUrl(String url) {
        this.url = url;
        return this;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Open.url(url)
        );
    }

    public static OpenHomePage openPage() {
        return new OpenHomePage();
    }
}
