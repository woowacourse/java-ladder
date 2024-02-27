package domain;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class LadderGame {
    private final Ladder ladder;
    private final Players players;
    private final Prizes prizes;


    public LadderGame(Ladder ladder, Players players, Prizes prizes) {
        this.ladder = ladder;
        this.players = players;
        this.prizes = prizes;
    }

    public PlayersPrize getPlayersPrize() {
        Map<Player, Prize> playersPrize = new LinkedHashMap<>();

        for (int columnIndex = 0; columnIndex < players.getPlayers().size(); columnIndex++) {
            Player player = players.getPlayers().get(columnIndex);
            int resultColumnIndex = playLines(columnIndex, ladder.getLines());
            Prize prize = prizes.getPrizes().get(resultColumnIndex);
            playersPrize.put(player, prize);
        }

        return new PlayersPrize(playersPrize);
    }

    private int playLines(int currentColumn, List<Line> lines) {
        for (Line line : lines) {
            currentColumn = playLine(currentColumn, line);
        }
        return currentColumn;
    }

    private int playLine(int currentColumn, Line line) {
        List<Step> steps = line.getSteps();
        if (steps.get(currentColumn).isExist()) {
            return currentColumn + 1;
        }
        if (currentColumn > 0 && steps.get(currentColumn - 1).isExist()) {
            return currentColumn - 1;
        }
        return currentColumn;
    }
}
