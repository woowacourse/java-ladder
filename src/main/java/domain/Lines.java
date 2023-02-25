package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lines {

    private static final String VALIDATE_LADDER_HEIGHT_MESSAGE = "사다리의 최소 높이는 1이상이어야 합니다.";

    private final List<Line> lines;

    public Lines(int personCount, int height) {
        validateLadderHeight(height);
        this.lines = createLines(personCount, height);
    }

    private void validateLadderHeight(int height) {
        if (height < 1) {
            throw new IllegalArgumentException(VALIDATE_LADDER_HEIGHT_MESSAGE);
        }
    }

    public List<Line> getLines() {
        return lines;
    }

    public int getLineHeight() {
        return lines.size();
    }

    private List<Line> createLines(int personCount, int height) {
        List<Line> lines = new ArrayList<>();
        while (height-- > 0) {
            lines.add(new Line(personCount));
        }
        return lines;
    }

    public void calculateResults(Players players, Results results) {
        List<Player> playerList = new ArrayList<>(players.getPlayers());
        for (Line line : lines) {
            playerList = switchingPlayers(line, playerList);
        }
        results.matchPlayerName(playerList);
    }

    public List<Player> switchingPlayers(Line line, List<Player> players) {
        for (int pointNumber = 0; pointNumber < line.getSize(); pointNumber++) {
            players = calculatePoints(line, pointNumber, players);
        }
        return players;
    }

    private List<Player> calculatePoints(Line line, int pointNumber, List<Player> players) {
        if (line.canGoThisPoint(pointNumber)) {
            Collections.swap(players, pointNumber, pointNumber + 1);
        }
        return players;
    }
}
