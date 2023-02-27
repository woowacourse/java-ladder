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

    public GameResult play() {
        for (Player player : players.getPlayers()) {
            player.findGameResult(ladder, items.getItems());
        }

        LinkedHashMap<String, String> results = new LinkedHashMap<>();
        for (Player player : players.getPlayers()) {
            results.put(player.getName(), player.getResult());
        }
        return new GameResult(results);
    }
}
