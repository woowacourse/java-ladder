package ladder.domain;

import java.util.LinkedHashMap;
import java.util.Map;

public class Game {

    private static final Name ALL = new Name("all");

    private final People people;
    private final Results results;
    private final Ladder ladder;

    public Game(People people, Results results, Ladder ladder) {
        this.people = people;
        this.results = results;
        this.ladder = ladder;
    }

    public Map<Name, String> play(Name target) {
        if (ALL.equals(target)) {
            return playAll();
        }
        String result = playOne(target);
        return Map.of(target, result);
    }

    private String playOne(Name target) {
        int startPosition = people.findPosition(target);
        int resultPosition = ladder.ride(startPosition);
        return results.find(resultPosition);
    }

    private Map<Name, String> playAll() {
        Map<Name, String> results = new LinkedHashMap<>();
        for (Name name : people.getNames()) {
            String result = playOne(name);
            results.put(name, result);
        }
        return results;
    }
}
