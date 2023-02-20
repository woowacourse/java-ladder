package ladder.model;

import java.util.ArrayList;
import java.util.List;

import static ladder.model.ErrorMessage.EXCEPTION_PLAYER_COUNT;

public class LadderGame {

    private static final int MIN_PLAYER_COUNT = 2;
    private static final int MAX_PLAYER_COUNT = 30;
    private final List<Player> players;
    private final Height height;
    private Ladder ladder;

    public LadderGame(List<Player> players, Height height) {
        validatePlayerCount(players);
        this.players = players;
        this.height = height;
    }

    private void validatePlayerCount(List<Player> players) {
        if (players.size() < MIN_PLAYER_COUNT || players.size() > MAX_PLAYER_COUNT) {
            throw new IllegalArgumentException(EXCEPTION_PLAYER_COUNT.getMessage());
        }
    }

    public void generateLadder(LineCreateDecider lineCreateDecider) {
        int personCount = players.size();
        List<Row> rows = new ArrayList<>();
        for (int i = 0; i < height.getHeight(); i++) {
            rows.add(new Row(personCount, lineCreateDecider));
        }
        ladder = new Ladder(rows);
    }

    public List<Player> getPlayers() {
        return players;
    }

    public Ladder getLadder() {
        return ladder;
    }

}
