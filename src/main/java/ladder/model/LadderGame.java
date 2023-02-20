package ladder.model;

import java.util.ArrayList;
import java.util.List;

import static ladder.model.ErrorMessage.EXCEPTION_PLAYER_COUNT;

public class LadderGame {

    private static final int MIN_PLAYER_COUNT = 2;
    private static final int MAX_PLAYER_COUNT = 30;
    private final List<Player> players;
    private final Height height;
    private final LineCreateDecider lineCreateDecider;
    private final Ladder ladder;

    public LadderGame(List<Player> players, Height height, LineCreateDecider lineCreateDecider) {
        validatePlayerCount(players);
        this.players = players;
        this.height = height;
        this.lineCreateDecider = lineCreateDecider;
        this.ladder = generateLadder();
    }

    private void validatePlayerCount(List<Player> players) {
        if (players.size() < MIN_PLAYER_COUNT || players.size() > MAX_PLAYER_COUNT) {
            throw new IllegalArgumentException(EXCEPTION_PLAYER_COUNT.getMessage());
        }
    }

    public Ladder generateLadder() {
        int personCount = players.size();
        List<Row> rows = new ArrayList<>();
        for (int i = 0; i < height.getHeight(); i++) {
            rows.add(new Row(personCount, lineCreateDecider));
        }
        return new Ladder(rows);
    }

    public List<Player> getPlayers() {
        return players;
    }

    public Ladder getLadder() {
        return ladder;
    }

}
