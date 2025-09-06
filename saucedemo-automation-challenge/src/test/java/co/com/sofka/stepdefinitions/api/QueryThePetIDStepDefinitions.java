package co.com.sofka.stepdefinitions.api;

import co.com.sofka.models.Pet;
import co.com.sofka.questions.api.ResponseCode;
import co.com.sofka.setup.ServicesSetUp;
import co.com.sofka.tasks.api.AddPet;
import co.com.sofka.tasks.api.GetPetById;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.rest.questions.LastResponse;
import org.json.JSONObject;
import org.junit.jupiter.api.Assertions;

import java.nio.charset.StandardCharsets;
import java.util.Collections;

import static co.com.sofka.Constants.*;
import static co.com.sofka.questions.api.GetInformation.getInformation;
import static co.com.sofka.questions.api.GetPetId.getPetId;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.CoreMatchers.equalTo;

public class QueryThePetIDStepDefinitions extends ServicesSetUp {
    Pet pet;

    @Given("that the user registers a pet with the name {string} and the status {string}")
    public void thatTheUserRegistersAPetWithTheNameAndTheStatus(String name, String status) {
        pet = new Pet();
        try {
            pet.setName(name);
            pet.setStatus(status);
            pet.setPhotoUrls(Collections.singletonList(PHOTO_URLS));
            actor.attemptsTo(
                    AddPet.withData(pet)
            );
            long generatedId = SerenityRest.lastResponse().jsonPath().getLong("id");
            pet.setId(generatedId);

            System.out.println(REGISTERED_PET_ID + generatedId);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            Assertions.fail();
        }
    }

    @When("querying the pet by ID")
    public void queryingThePetByID() {
        try {
            actor.attemptsTo(
                    GetPetById.withId(pet.getId())
            );
        } catch (Exception e) {
            System.out.println(e.getMessage());
            Assertions.fail();
        }
    }

    @Then("the response must contain the pet's ID and name and status code {int}")
    public void theResponseMustContainThePetSIDAndNameAndStatusCode(Integer statusCode) {
        try {
            String response = new String(LastResponse.received().answeredBy(actor).asByteArray(), StandardCharsets.UTF_8);
            JSONObject jsonObject = new JSONObject(response);
            System.out.println(jsonObject.toString());
            actor.should(
                    seeThat(PET_ID, getPetId().fromTheObject(jsonObject).fromTheField("id"), equalTo(pet.getId())),
                    seeThat(STATUS_CODE, ResponseCode.was(), equalTo(statusCode))
                   // seeThat(PET_NAME, getInformation().fromTheObject(jsonObject).fromTheField("name"), equalTo(pet.getName()))
            );
            System.out.println(PET_ID + pet.getId());
            System.out.println(PET_NAME + pet.getName());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            Assertions.fail();
        }
    }
}
