package co.com.sofka.tasks.api;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Get;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class GetPetById implements Task {
    private final long id;

    public GetPetById(long id) {
        this.id = id;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Get.resource("/pet/" + id)
        );
    }

    public static GetPetById withId(long id) {
        return instrumented(GetPetById.class, id);
    }
}
