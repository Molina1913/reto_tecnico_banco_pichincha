package co.com.sofka.stepdefinitions.api;

import co.com.sofka.questions.api.ResponseCode;
import co.com.sofka.questions.api.ValidateAllStatuses;
import co.com.sofka.setup.ServicesSetUp;
import co.com.sofka.tasks.api.SearchPetsByStatus;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.hamcrest.CoreMatchers;

import static co.com.sofka.Constants.STATUS_CODE;
import static com.google.common.base.Predicates.equalTo;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;

public class SearchPetsByStatusStepDefinitions extends ServicesSetUp {
    private String status;

    @Given("the user searches for pets by status")
    public void theUserSearchesForPetsByStatus() {

    }

    @When("querying pets with the status {string}")
    public void queryingPetsWithTheStatus(String status) {
        this.status = status;
        actor.attemptsTo(
                SearchPetsByStatus.withStatus(status)
        );
    }

    @Then("the list must contain pets with the status {string}")
    public void theListMustContainPetsWithTheStatus(String status) {
        actor.should(
                seeThat(
                        ValidateAllStatuses.fromResponse(status),
                        equalTo(true)
                )
        );
    }

    @Then("the list must contain pets with the status {string} and status code {int}")
    public void theListMustContainPetsWithTheStatusAndStatusCode(String status, Integer statusCode) {
        actor.should(
                seeThat(ValidateAllStatuses.fromResponse(status), equalTo(true)),
                seeThat(STATUS_CODE, ResponseCode.was(), CoreMatchers.equalTo(statusCode))
        );
    }
}
