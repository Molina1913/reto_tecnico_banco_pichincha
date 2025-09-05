package co.com.sofka.questions.api;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import org.json.JSONObject;

public class GetInformation implements Question<String> {
    String field;
    JSONObject jsonObject;

    public GetInformation fromTheObject(JSONObject jsonObject) {
        this.jsonObject = jsonObject;
        return this;
    }

    public GetInformation fromTheField(String field) {
        this.field = field;
        return this;
    }

    @Override
    public String answeredBy(Actor actor) {
        return jsonObject.getString(field);
    }

    public static GetInformation getInformation() {
        return new GetInformation();
    }
}
