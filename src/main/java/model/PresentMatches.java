package model;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PresentMatches {
    private final Map<PersonName, Present> matches;

    private PresentMatches(Map<PersonName, Present> matches) {
        this.matches = matches;
    }

    public static PresentMatches from(People people, Presents presents) {
        List<Person> personGroup = people.getPersonGroup();
        Map<PersonName, Present> personNamePresent = personGroup.stream()
                .collect(Collectors.toMap(
                        Person::getPersonName,
                        person -> presents.getPresent(person.getColumn())));
        return new PresentMatches(personNamePresent);
    }

    public Present findByPersonName(PersonName personName) {
        return matches.get(personName);
    }
}
