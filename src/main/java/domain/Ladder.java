package domain;

import util.BooleanGenerator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ladder {

    private final List<Line> ladder;

    private Ladder(List<Line> ladder) {
        this.ladder = ladder;
    }

    public static Ladder of(Height height, int playersCount, BooleanGenerator booleanGenerator) {
        List<Line> ladder = new ArrayList<>();

        makeLadder(ladder, height.getHeight(), playersCount, booleanGenerator);

        return new Ladder(ladder);
    }

    private static void makeLadder(List<Line> ladder, int height, int playersCount, BooleanGenerator booleanGenerator) {
        for (int i = 0; i < height; i++) {
            Line line = new Line(playersCount);
            line.makeLine(booleanGenerator);

            ladder.add(line);
        }
    }

    public void playLadder(GameResult gameResult, Prizes prizes, Players players) {
        for (int initPosition = 0; initPosition < players.getPlayersCount(); initPosition++) {
            Player player = players.findPlayersByPosition(initPosition);
            int position = getNextPosition(initPosition);

            gameResult.recordPlayersResult(player, prizes, position);
        }
    }

    private int getNextPosition(int initPosition) {
        int position = initPosition;

        for (Line line : ladder) {
            position = line.decideNextPosition(position);
        }

        return position;
    }

    public List<Line> getLadder() {
        return Collections.unmodifiableList(ladder);
    }
}
