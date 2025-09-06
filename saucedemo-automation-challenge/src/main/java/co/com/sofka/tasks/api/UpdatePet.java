package co.com.sofka.tasks.api;

import co.com.sofka.models.Pet;
import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Put;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class UpdatePet implements Task {
    private final Pet pet;

    public UpdatePet(Pet pet) {
        this.pet = pet;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Put.to("/pet")
                        .with(request -> request
                                .contentType(ContentType.JSON)
                                .body(pet))
        );
    }

    public static UpdatePet withData(Pet pet) {
        return instrumented(UpdatePet.class, pet);
    }
}
