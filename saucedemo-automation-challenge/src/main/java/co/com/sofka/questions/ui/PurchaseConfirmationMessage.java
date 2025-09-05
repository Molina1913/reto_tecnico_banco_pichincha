package co.com.sofka.questions.ui;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static co.com.sofka.ui.ConfirmationPage.CONFIRMATION_MESSAGE;

public class PurchaseConfirmationMessage implements Question<String> {
    @Override
    public String answeredBy(Actor actor) {
        return CONFIRMATION_MESSAGE.resolveFor(actor).getText();
    }

    public static PurchaseConfirmationMessage purchaseConfirmationMessage() {
        return new PurchaseConfirmationMessage();
    }
}
