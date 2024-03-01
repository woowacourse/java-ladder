package domain.model.ladder;

import domain.model.consequence.Consequence;
import domain.model.consequence.Consequences;
import domain.model.participant.People;
import domain.model.participant.Person;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class Result {
    private final People people;
    private final Consequences consequences;
    private final Map<Person, Consequence> result = new LinkedHashMap<>();

    public Result(People people, Consequences consequences) {
        this.people = people;
        this.consequences = consequences;
    }

    public void make(int positionOfPerson, int positionOfConsequence) {
        Person person = people.getNameByOrder(positionOfPerson);
        Consequence consequence = consequences.getConsequenceByOrder(positionOfConsequence);
        result.put(person, consequence);
    }

    public String showConsequence(Person person) {
        return result.get(person).getValue();
    }

    public Map<Person, Consequence> giveResult() {
        return Collections.unmodifiableMap(new LinkedHashMap<>(result));
    }
}

