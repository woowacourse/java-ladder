package domain;

import java.util.LinkedHashMap;
import java.util.Map;

public class LadderGame {

    public static final int START_LINE = 0;
    private final Players players;
    private final Ladder ladder;
    private final Prizes prizes;

    public LadderGame(Players players, Ladder ladder, Prizes prizes) {
        this.players = players;
        this.ladder = ladder;
        this.prizes = prizes;
    }

    public Map<Player, Prize> playGame(Players players, Ladder ladder, Prizes prizes) {
        Map<Player, Prize> result = new LinkedHashMap<>();
        for (int player = 0; player < players.getPlayersSize(); player++) {
            int movedPlayerPosition = playerMoveLadder(player, ladder);
            result.put(players.getPlayer(player), prizes.getPrize(movedPlayerPosition));
        }
        return result;
    }

    private int playerMoveLadder(int position, Ladder ladder) {
        for (Line line : ladder.getLines()) {
            position = playerMoveLine(position, line);
        }
        return position;
    }

    private int playerMoveLine(int position, Line line) {
        if (position == START_LINE) {
            return firstBlockMoveRule(position, line);
        }
        if (START_LINE < position && position < line.getLineSize()) {
            return middleBlockMoveRule(position, line);
        }
        return lastBlockMoveRule(position, line);
    }


    private int firstBlockMoveRule(int position, Line line) {
        if (line.isCross(position)) {
            position++;
        }
        return position;
    }

    private int lastBlockMoveRule(int position, Line line) {
        int lastLine = position - 1;
        if (line.isCross(lastLine)) {
            position--;
        }
        return position;
    }

    private int middleBlockMoveRule(int position, Line line) {
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
