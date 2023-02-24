package ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LadderGame {

    private static final int LADDER_WIDTH_SUBTRACT_VALUE = 1;

    private final Players players;
    private final Ladder ladder;

    public LadderGame(final LadderGameCreateLineBooleanGenerator booleanGenerator, final Players players,
                      final Height height) {
        this.players = players;
        this.ladder = new Ladder(booleanGenerator, height, players.count() - LADDER_WIDTH_SUBTRACT_VALUE);
    }

    public List<String> getPlayerNames() {
        return players.getNames();
    }

    public List<Line> getLadder() {
        return ladder.getLines();
    }

    public Players makePlayersWhoFinishedGame(final Height height) {
        List<Line> lines = ladder.getLines();
        int width = players.count() - 1;

        List<String> playerNames = new ArrayList<>(getPlayerNames());
        for (int index = 0; index < height.getHeight(); index++) {
            crossConnectedLine(width, lines.get(index), playerNames);
        }

        return new Players(playerNames);
    }

    private void crossConnectedLine(final int width, final Line line, final List<String> playerNames) {
        for (int index = 0; index < width; index++) {
            changePlayerByConnected(index, line.isConnected(index), playerNames);
        }
    }

    private void changePlayerByConnected(final int index, final boolean connected, final List<String> playerNames) {
        if (connected) {
            Collections.swap(playerNames, index, index + 1);
        }
    }
}
