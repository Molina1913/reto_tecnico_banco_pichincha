package co.com.sofka.questions.api;

import io.restassured.response.Response;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.rest.questions.LastResponse;

import java.util.List;
import java.util.Map;

public class ValidateAllStatuses implements Question<Boolean> {
    private final String expectedStatus;

    public ValidateAllStatuses(String expectedStatus) {
        this.expectedStatus = expectedStatus;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        Response response = LastResponse.received().answeredBy(actor);
        List<Map<String, Object>> pets = response.jsonPath().getList("");

        if (pets == null || pets.isEmpty()) {
            System.out.println("Pets not found" + expectedStatus);
            return false;
        }

        for (Map<String, Object> pet : pets) {
            String actualStatus = String.valueOf(pet.get("status"));
            if (!expectedStatus.equalsIgnoreCase(actualStatus)) {
                System.out.println("Pet found with other status" + actualStatus);
                return false;
            }
        }

        return true;
    }

    public static ValidateAllStatuses fromResponse(String expectedStatus) {
        return new ValidateAllStatuses(expectedStatus);
    }
}
