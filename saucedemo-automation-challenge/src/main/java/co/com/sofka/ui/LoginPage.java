package co.com.sofka.ui;

import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.findby.By;
import net.thucydides.core.pages.PageObject;

public class LoginPage extends PageObject {
    public static final Target USERNAME_INPUT = Target
            .the("username input").located(By.id("user-name"));
    public static final Target PASSWORD_INPUT = Target
            .the("password input").located(By.id("password"));
    public static final Target LOGIN_BUTTON = Target
            .the("login button").located(By.id("login-button"));
}
