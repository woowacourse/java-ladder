package model.game;

import java.util.LinkedHashMap;
import java.util.List;
import model.bridge.Bridge;
import model.ladder.Ladder;
import model.line.Line;
import model.player.Player;
import model.player.Players;
import model.prize.Prize;
import model.prize.Prizes;

public class Game {
    private final Ladder ladder;
    private final Players players;
    private final Prizes prizes;

    public Game(final Ladder ladder, final Players players, final Prizes prizes) {
        this.ladder = ladder;
        this.players = players;
        this.prizes = prizes;
    }

    public GameResult play() {
        LinkedHashMap<Player, Prize> result = new LinkedHashMap<>();
        for (int index = 0; index < players.getSize(); index++) {
            Player player = players.get(index);
            int resultIndex = playLadder(index);
            Prize prize = prizes.get(resultIndex);
            result.put(player, prize);
        }
        return new GameResult(result);
    }

    private int playLadder(int currentIndex) {
        for (Line line : ladder.getLines()) {
            currentIndex = playLine(currentIndex, line);
        }
        return currentIndex;
    }

    private int playLine(int currentIndex, Line line) {
        List<Bridge> bridges = line.getBridges();
        if (currentIndex > 0 && bridges.get(currentIndex - 1).isConnected()) {
            return currentIndex - 1;
        }
        if (currentIndex < bridges.size() && bridges.get(currentIndex).isConnected()) {
            return currentIndex + 1;
        }
        return currentIndex;
    }
}
