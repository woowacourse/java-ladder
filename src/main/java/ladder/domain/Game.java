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

    public String play(Name target) {
        int startPosition = people.findPosition(target);
        int resultPosition = ladder.ride(startPosition);
        return results.find(resultPosition);
    }

    public Map<Name, String> playAll() {
        Map<Name, String> results = new LinkedHashMap<>();
        for (Name name : people.getNames()) {
            String result = play(name);
            results.put(name, result);
        }
        return results;
    }
}
