package model;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PresentMatches {
    private final Map<PersonName, Present> matches;

    public PresentMatches(final Map<PersonName, Present> matches) {
        this.matches = matches;
    }

    public Present findByPersonName(final PersonName personName) {
        return matches.get(personName);
    }
}
