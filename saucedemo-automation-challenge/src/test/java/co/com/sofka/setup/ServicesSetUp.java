package co.com.sofka.setup;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;

import static co.com.sofka.Constants.ACTOR_NAME;

public class ServicesSetUp {
    protected static Actor actor=new Actor(ACTOR_NAME);

    protected void setUpServiceGet(String url){
        actor.can(CallAnApi.at(url));
    }
}
