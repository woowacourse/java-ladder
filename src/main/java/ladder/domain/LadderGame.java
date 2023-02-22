package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LadderGame {

    private final Players players;
    private final Results results;
    private final Ladder ladder;

    public LadderGame(List<String> names, List<String> results, int height) {
        this.players = new Players(generatePlayers(names));
        this.results = new Results(generateResults(results));
        LadderMaker ladderMaker = new LadderMaker(new LadderProperty(names.size() - 1, height));

        this.ladder = ladderMaker.generate();
    }

    private List<Player> generatePlayers(List<String> names) {
        List<Player> gamePlayers = new ArrayList<>();
        for (int startIndex = 0; startIndex < names.size(); startIndex++) {
            Name name = new Name(names.get(startIndex));
            gamePlayers.add(new Player(name, startIndex));
        }
        return gamePlayers;
    }

    private List<Result> generateResults(List<String> results) {
        return results.stream()
                .map(Result::new)
                .collect(Collectors.toUnmodifiableList());
    }

    public List<String> getNames () {
        return players.getNames();
    }

    public List<Line> getLines() {
        return ladder.getLines();
    }
}
