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

        for (int index = 0; players.isCountMoreThan(index); index++) {
            Player player = players.findByIndex(index);
            int resultIndex = playLadder(index);
            Prize prize = prizes.findByIndex(resultIndex);
            playersPrize.put(player, prize);
        }

        return new PlayersPrize(playersPrize);
    }

    private int playLadder(int currentIndex) {
        for (Line line : ladder.getLines()) {
            currentIndex = playLine(currentIndex, line);
        }
        return currentIndex;
    }

    private int playLine(int currentIndex, Line line) {
        List<Step> steps = line.getSteps();
        if (steps.get(currentIndex).isExist()) {
            return currentIndex + 1;
        }
        if (currentIndex > 0 && steps.get(currentIndex - 1).isExist()) {
            return currentIndex - 1;
        }
        return currentIndex;
    }
}
