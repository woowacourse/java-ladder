package domain;

import java.util.HashMap;
import java.util.Map;

public class LadderGame {

    private final Ladder ladder;
    private final Players players;
    private final Prize prize;

    public LadderGame(Ladder ladder, Players players, Prize prize) {
        this.ladder = ladder;
        this.players = players;
        this.prize = prize;
    }

    public Map<String, String> run() {
        play();
        return finish();
    }

    private Map<String, String> finish() {
        HashMap<String, String> result = new HashMap<>();
        for (Player player : players.getPlayers()) {
            int position = player.getPosition();
            result.put(player.getName(), prize.getOnePrizeByIndex(position));
        }
        return result;
    }

    private void play() {
        for (Line line : ladder.getLadder()) {
            players.move(line);
        }
    }
}
