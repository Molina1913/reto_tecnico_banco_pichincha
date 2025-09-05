package co.com.sofka.tasks.api;

import co.com.sofka.models.Pet;
import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Post;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class AddPet implements Task {
    private final Pet pet;

    public AddPet(Pet pet) {
        this.pet = pet;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Post.to("/pet")
                        .with(requestSpecification -> requestSpecification
                                .contentType(ContentType.JSON)
                                .body(pet))
        );
    }

    public static AddPet withData(Pet pet) {
        return instrumented(AddPet.class, pet);
    }
}



