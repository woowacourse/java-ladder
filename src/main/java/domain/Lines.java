package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lines {

    private static final String MINIMUM_LADDER_HEIGHT_MORE_THAN_ONE = "사다리의 최소 높이는 1이상이어야 합니다.";

    private final List<Line> lines;

    public Lines(int personCount, int height) {
        validateLadderHeight(height);
        this.lines = createLines(personCount, height);
    }

    private void validateLadderHeight(int height) {
        if (height < 1) {
            throw new IllegalArgumentException(MINIMUM_LADDER_HEIGHT_MORE_THAN_ONE);
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

    // Lines 객체는 특정 위치가 주어졌을 때 이동하고 최종 위치를 가지고만 있으면 된다.
    public void calculateResults(Players players, Results results) {
        List<Player> playerList = new ArrayList<>(players.getPlayers());
        for (Line line : lines) {
            playerList = switchingPlayers(line, playerList);
        }
        results.matchPlayerName(playerList);
    }

    public List<Player> switchingPlayers(Line line, List<Player> players) {
        for (int pointNumber = 0; pointNumber < line.getSize(); pointNumber++) {
            calculatePoints(line, pointNumber, players);
        }
        return players;
    }

    private List<Player> calculatePoints(Line line, int pointNumber, List<Player> players) {
        if (line.isMovable(pointNumber)) {
            Collections.swap(players, pointNumber, pointNumber + 1);
        }
        return players;
    }
}
