package co.com.sofka.stepdefinitions.api;

import co.com.sofka.models.Pet;
import co.com.sofka.questions.api.ResponseCode;
import co.com.sofka.setup.ServicesSetUp;
import co.com.sofka.tasks.api.AddPet;
import co.com.sofka.tasks.api.UpdatePet;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.rest.questions.LastResponse;
import org.hamcrest.CoreMatchers;
import org.json.JSONObject;

import java.nio.charset.StandardCharsets;
import java.util.Collections;

import static co.com.sofka.Constants.*;
import static co.com.sofka.questions.api.GetInformation.getInformation;
import static co.com.sofka.questions.api.GetPetId.getPetId;
import static com.google.common.base.Predicates.equalTo;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;

public class UpdatePetStepDefinitions extends ServicesSetUp {
    Pet pet;

    @Given("the user wants to update the pet")
    public void theUserWantsToUpdateThePet() {
        pet = new Pet();
        pet.setName("Firulais");
        pet.setStatus("available");
        pet.setPhotoUrls(Collections.singletonList(PHOTO_URLS));

        actor.attemptsTo(
                AddPet.withData(pet)
        );

        long generatedId = SerenityRest.lastResponse().jsonPath().getLong("id");
        pet.setId(generatedId);
    }

    @When("changing the name to {string} and the status to {string}")
    public void changingTheNameToAndTheStatusTo(String name, String status) {
        pet.setName(name);
        pet.setStatus(status);

        actor.attemptsTo(
                UpdatePet.withData(pet)
        );
    }

    @Then("the pet must reflect the changes and status code should be {int}")
    public void thePetMustReflectTheChangesAndStatusCodeShouldBe(Integer statusCode) {
        String response = new String(LastResponse.received().answeredBy(actor).asByteArray(), StandardCharsets.UTF_8);
        JSONObject jsonObject = new JSONObject(response);

        actor.should(
                seeThat(PET_ID, getPetId().fromTheObject(jsonObject).fromTheField("id"), equalTo(pet.getId())),
                seeThat(PET_NAME, getInformation().fromTheObject(jsonObject).fromTheField("name"), equalTo(pet.getName())),
                seeThat(STATUS_CODE, ResponseCode.was(), CoreMatchers.equalTo(statusCode))
        );
    }
}
