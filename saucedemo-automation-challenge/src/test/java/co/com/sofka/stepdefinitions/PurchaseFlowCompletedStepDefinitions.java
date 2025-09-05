package co.com.sofka.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

import static co.com.sofka.Constants.*;
import static co.com.sofka.Constants.ACTUAL_MESSAGE;
import static co.com.sofka.Constants.EXPECTED_MESSAGE;
import static co.com.sofka.interactions.ClickLoginButton.clickLoginButton;
import static co.com.sofka.interactions.ClickShoppingCartButton.clickShoppingCartButton;
import static co.com.sofka.questions.PurchaseConfirmationMessage.purchaseConfirmationMessage;
import static co.com.sofka.tasks.CompletePurchase.completePurchase;
import static co.com.sofka.tasks.EnterPassword.enterPassword;
import static co.com.sofka.tasks.EnterUserName.enterUserName;
import static co.com.sofka.setup.SetUpSelection.setUpSelection;
import static co.com.sofka.tasks.OpenHomePage.openPage;
import static co.com.sofka.tasks.SelectARandomItem.selectARandomItem;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.CoreMatchers.equalTo;

public class PurchaseFlowCompletedStepDefinitions {

    @Given("the user opens the SauceDemo app")
    public void theUserOpensTheSauceDemoApp() {
        try {
            setUpSelection(1);
            theActorInTheSpotlight().wasAbleTo(
                    openPage().withUrl(URL)
            );
        } catch (Exception e) {
            System.out.println(e.getMessage());
            Assertions.fail();
        }
    }

    @When("the user logs in with valid credentials username {string} paswword {string}")
    public void theUserLogsInWithValidCredentialsUsernamePaswword(String username, String password) {
        try {
            theActorInTheSpotlight().attemptsTo(
                    enterUserName().withUsername(username),
                    enterPassword().withPassword(password),
                    clickLoginButton()
            );
            System.out.println(USER_AUTHENTICATED);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            Assertions.fail();
        }
    }

    @When("adds two products to the cart")
    public void addsTwoProductsToTheCart() {
        try {
            theActorInTheSpotlight().attemptsTo(
                    selectARandomItem(),
                    selectARandomItem()
            );
            System.out.println(ITEMS_ADDED);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            Assertions.fail();
        }
    }

    @When("views the cart")
    public void viewsTheCart() {
        try {
            theActorInTheSpotlight().attemptsTo(
                    clickShoppingCartButton()
            );
            System.out.println(CART_VIEW);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            Assertions.fail();
        }
    }

    @When("completes the purchase form with the following information first name {string} last name {string} postal code {string}")
    public void completesThePurchaseFormWithTheFollowingInformationFirstNameLastNamePostalCode(String firstName, String lastName, String postalCode) {
        try {
            theActorInTheSpotlight().attemptsTo(
                    completePurchase().withInfo(firstName, lastName, postalCode)
            );
            Thread.sleep(6000);
            System.out.println(PURCHASE_COMPLETED);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            Assertions.fail();
        }
    }

    @Then("the user should see the confirmation message {string}")
    public void theUserShouldSeeTheConfirmationMessage(String expectedMessage) {
        try {
            theActorInTheSpotlight().should(
                    seeThat(purchaseConfirmationMessage(), equalTo(expectedMessage))
            );
            System.out.println(ACTUAL_MESSAGE + purchaseConfirmationMessage().answeredBy(theActorInTheSpotlight()));
            System.out.println(EXPECTED_MESSAGE + expectedMessage);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            Assertions.fail();
        }
    }


}
