package co.com.sofka.tasks.api;

import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Get;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class SearchPetsByStatus implements Task {
    private final String status;

    public SearchPetsByStatus(String status) {
        this.status = status;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Get.resource("/pet/findByStatus")
                        .with(request -> request
                                .queryParam("status", status)
                                .contentType(ContentType.JSON)
                        )
        );
    }

    public static SearchPetsByStatus withStatus(String status) {
        return instrumented(SearchPetsByStatus.class, status);
    }
}
