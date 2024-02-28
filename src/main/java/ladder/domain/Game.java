package ladder.domain;

import java.util.List;

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

    public List<String> playAll() {
        return people.getNames()
                .stream()
                .map(this::play)
                .toList();
    }
}
