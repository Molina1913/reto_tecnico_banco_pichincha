package co.com.sofka.tasks.ui;

import net.serenitybdd.core.pages.ListOfWebElementFacades;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import static co.com.sofka.ui.HomePage.INVENTORY_LIST;
import static co.com.sofka.util.Utils.selectRandomItem;

public class SelectARandomItem implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        ListOfWebElementFacades items = INVENTORY_LIST.resolveAllFor(actor);
        WebElementFacade itemSelected = selectRandomItem(items);
        actor.attemptsTo(
                Click.on(itemSelected)
        );
    }

    public static SelectARandomItem selectARandomItem() {
        return new SelectARandomItem();
    }
}
