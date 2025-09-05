package co.com.sofka.stepdefinitions.api;

import co.com.sofka.models.Pet;
import co.com.sofka.questions.api.ResponseCode;
import co.com.sofka.setup.ServicesSetUp;
import co.com.sofka.tasks.api.AddPet;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.rest.questions.LastResponse;
import org.json.JSONObject;
import org.junit.jupiter.api.Assertions;


import java.nio.charset.StandardCharsets;

import static co.com.sofka.Constants.PET_NAME;
import static co.com.sofka.Constants.STATUS_CODE;
import static co.com.sofka.questions.api.GetInformation.getInformation;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.assertj.core.api.FactoryBasedNavigableListAssert.assertThat;
import static org.hamcrest.CoreMatchers.equalTo;

public class AddPetToStoreStepDefinitions extends ServicesSetUp {
    Pet pet = new Pet();

    @Given("the user has access to petstore API {string}")
    public void theUserHasAccessToPetstoreAPI(String url) {
        try {
            setUpServiceGet(url);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            Assertions.fail();
        }
    }

    @When("the user adds a pet with the name {string} and status {string}")
    public void theUserAddsAPetWithTheNameAndStatus(String name, String status) {
        try {
            pet.setName(name);
            pet.setStatus(status);
            actor.attemptsTo(
                    AddPet.withData(pet)
            );
        } catch (Exception e) {
            System.out.println(e.getMessage());
            Assertions.fail();
        }
    }


    @Then("the response must contain the name {string} and status code {int}")
    public void theResponseMustContainTheNameAndStatusCode(String name, Integer statusCode) {
        try {
            String response = new String(LastResponse.received().answeredBy(actor).asByteArray(), StandardCharsets.UTF_8);
            JSONObject jsonObject = new JSONObject(response);

            actor.should(
                    seeThat(PET_NAME, getInformation().fromTheObject(jsonObject).fromTheField("name"), equalTo(name)),
                    seeThat(STATUS_CODE, ResponseCode.was(), equalTo(statusCode))
            );
        } catch (Exception e) {
            System.out.println(e.getMessage());
            Assertions.fail();
        }
    }

}
