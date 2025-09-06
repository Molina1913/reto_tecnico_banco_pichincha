package co.com.sofka.questions.api;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import org.json.JSONObject;

public class GetPetId implements Question<Long> {
    String field;
    JSONObject jsonObject;

    public GetPetId fromTheObject(JSONObject jsonObject) {
        this.jsonObject = jsonObject;
        return this;
    }

    public GetPetId fromTheField(String field) {
        this.field = field;
        return this;
    }

    @Override
    public Long answeredBy(Actor actor) {
        return jsonObject.getLong(field);
    }

    public static GetPetId getPetId() {
        return new GetPetId();
    }
}
