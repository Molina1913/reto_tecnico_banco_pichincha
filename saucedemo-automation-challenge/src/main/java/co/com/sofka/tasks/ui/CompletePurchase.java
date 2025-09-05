package co.com.sofka.tasks.ui;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

import static co.com.sofka.interactions.ClickCheckoutButton.clickCheckoutButton;
import static co.com.sofka.interactions.ClickContinueButton.clickContinueButton;
import static co.com.sofka.interactions.ClickFinishButton.clickFinishButton;
import static co.com.sofka.interactions.EnterFirstName.enterFirstName;
import static co.com.sofka.interactions.EnterLastName.enterLastName;
import static co.com.sofka.interactions.EnterPostalCode.enterPostalCode;

public class CompletePurchase implements Task {
    String firstname;
    String lastName;
    String postalCode;

    public CompletePurchase withInfo(String firstname, String lastName, String postalCode) {
        this.firstname = firstname;
        this.lastName = lastName;
        this.postalCode = postalCode;
        return this;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                clickCheckoutButton(),
                enterFirstName().withUsername(firstname),
                enterLastName().withLastName(lastName),
                enterPostalCode().withNumber(postalCode),
                clickContinueButton(),
                clickFinishButton()
        );
    }


    public static CompletePurchase completePurchase() {
        return new CompletePurchase();
    }
}
