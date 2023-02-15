package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LadderGame {

    private final List<Line> lines;
    private final List<Name> players;

    public LadderGame(int height, List<String> players) {
        this.players = players.stream()
                .map(Name::new)
                .collect(Collectors.toList());
        this.lines = initializeLines(height);
    }

    private List<Line> initializeLines(int height) {
        int playerCount = players.size();
        List<Line> result = new ArrayList<>();

        for (int i = 0; i < height; i++) {
            result.add(new Line(playerCount));
        }

        return result;
    }

    public List<Line> getLines() {
        return this.lines;
    }
}
