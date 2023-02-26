package domain.ladderGame;

import domain.item.Items;
import domain.ladder.Ladder;
import domain.player.Player;
import domain.player.Players;

import java.util.LinkedHashMap;

public class LadderGame {

    private final Players players;
    private final Ladder ladder;
    private final Items items;

    public LadderGame(GameInit gameInit) {
        this.players = gameInit.getPlayers();
        this.ladder = gameInit.getLadder();
        this.items = gameInit.getItems();
    }

    public void play() {
        for (Player player : players.getPlayers()) {
            player.findGameResult(ladder, items.getItems());
        }
    }

    public GameResult getGameResult() {
        LinkedHashMap<String, String> gameResult = new LinkedHashMap<>();
        for (Player player : players.getPlayers()) {
            gameResult.put(player.getName(), player.getResult());
        }
        return new GameResult(gameResult);
    }
}
