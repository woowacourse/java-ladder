package domain.model.ladder;

import domain.model.consequence.Consequence;
import domain.model.participant.Person;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class Result {
    private final Map<Person, Consequence> result = new LinkedHashMap<>();

    public void make(Person person, Consequence consequence) {
        result.put(person, consequence);
    }

    public String showConsequence(Person person) {
        return result.get(person).getValue();
    }

    public Map<Person, Consequence> giveResult() {
        return Collections.unmodifiableMap(new LinkedHashMap<>(result));
    }
}

