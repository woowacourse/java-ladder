package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class LadderGame {

    private final List<Line> lines;
    private final List<String> players;

    public LadderGame(int height, List<String> players) {
        this.players = players;
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
