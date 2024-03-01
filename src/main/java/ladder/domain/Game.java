package ladder.domain;

import java.util.LinkedHashMap;
import java.util.Map;

public class Game {

    private final People people;
    private final Results results;
    private final Ladder ladder;

    public Game(People people, Results results, Ladder ladder) {
        this.people = people;
        this.results = results;
        this.ladder = ladder;
    }

    public PlayResults play(Name target) {
        if (target.isAll()) {
            return playAll();
        }
        Result result = playOne(target);
        return new PlayResults(Map.of(target, result));
    }

    private Result playOne(Name target) {
        int startPosition = people.findPosition(target);
        int resultPosition = ladder.ride(startPosition);
        return results.find(resultPosition);
    }

    private PlayResults playAll() {
        Map<Name, Result> results = new LinkedHashMap<>();
        for (Name name : people.getNames()) {
            Result result = playOne(name);
            results.put(name, result);
        }
        return new PlayResults(results);
    }
}
