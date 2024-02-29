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

    public Map<Name, Result> play(Name target) {
        if (ALL.equals(target)) {
            return playAll();
        }
        Result result = playOne(target);
        return Map.of(target, result);
    }

    private Result playOne(Name target) {
        int startPosition = people.findPosition(target);
        int resultPosition = ladder.ride(startPosition);
        return results.find(resultPosition);
    }

    private Map<Name, Result> playAll() {
        Map<Name, Result> results = new LinkedHashMap<>();
        for (Name name : people.getNames()) {
            Result result = playOne(name);
            results.put(name, result);
        }
        return results;
    }
}
