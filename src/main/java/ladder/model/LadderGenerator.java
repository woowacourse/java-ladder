package ladder.model;

import java.util.ArrayList;
import java.util.List;

public class LadderGame {

    private final Players players;
    private final Height height;
    private final LineCreateDecider lineCreateDecider;
    private final Ladder ladder;

    public LadderGame(Players players, Height height, LineCreateDecider lineCreateDecider) {
        this.players = players;
        this.height = height;
        this.lineCreateDecider = lineCreateDecider;
        this.ladder = generateLadder();
    }

    public Ladder generateLadder() {
        int personCount = players.size();
        List<Row> rows = new ArrayList<>();
        for (int i = 0; i < height.getHeight(); i++) {
            rows.add(new Row(personCount, lineCreateDecider));
        }
        return new Ladder(rows);
    }

    public Players getPlayers() {
        return players;
    }

    public Ladder getLadder() {
        return ladder;
    }

}
