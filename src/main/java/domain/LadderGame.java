package domain;

import java.util.LinkedHashMap;
import java.util.Map;

public class LadderGame {

    private final Players players;
    private final Ladder ladder;
    private final Prizes prizes;

    public LadderGame(Players players, Ladder ladder, Prizes prizes) {
        this.players = players;
        this.ladder = ladder;
        this.prizes = prizes;
    }

    public LadderGameResult playGame() {
        Map<Player, Prize> result = new LinkedHashMap<>();
        for (int player = 0; player < players.getPlayersSize(); player++) {
            int movedPlayerPosition = playerMoveLadder(player, ladder);
            result.put(players.getPlayer(player), prizes.getPrize(movedPlayerPosition));
        }
        return new LadderGameResult(result);
    }

    private int playerMoveLadder(int position, Ladder ladder) {
        for (Line line : ladder.getLines()) {
            position = playerMoveLine(position, line);
        }
        return position;
    }

    private int playerMoveLine(int position, Line line) {
        int leftLine = position - 1;
        boolean possibleToMoveLeft = line.isCross(leftLine);
        boolean PossibleToMoveRight = line.isCross(position);

        if (possibleToMoveLeft) {
            position--;
        }
        if (PossibleToMoveRight) {
            position++;
        }
        return position;
    }
}
