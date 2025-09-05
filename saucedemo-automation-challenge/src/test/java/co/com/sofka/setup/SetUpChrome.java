package co.com.sofka.setup;

import net.serenitybdd.annotations.Managed;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static co.com.sofka.Constants.ACTOR_NAME;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;

public class SetUpChrome {
    @Managed(driver = "chrome")
    protected static WebDriver driver;

    private static void setUpActor(WebDriver driver) {
        OnStage.setTheStage(new OnlineCast());
        theActorCalled(ACTOR_NAME).can(BrowseTheWeb.with(settingDriver()));
    }

    private static WebDriver settingDriver() {
        ChromeOptions co = new ChromeOptions();
        co.addArguments("--incognito");
        co.addArguments("--disable-notifications");
        driver = new ChromeDriver(co);
        return driver;
    }

    public static void actorSetUpTheBrowserChrome() {
        setUpActor(driver);
        maximize(driver);
    }

    private static void maximize(WebDriver driver) {
        driver.manage().window().maximize();
    }
}
