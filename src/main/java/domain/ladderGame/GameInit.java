package domain.ladderGame;

import domain.item.Items;
import domain.ladder.Ladder;
import domain.player.Players;

public class GameInit {

    private final Players players;
    private final Ladder ladder;
    private final Items items;

    public GameInit(Players players, Ladder ladder, Items items) {
        this.players = players;
        this.ladder = ladder;
        this.items = items;
    }

    public Players getPlayers() {
        return players;
    }

    public Ladder getLadder() {
        return ladder;
    }

    public Items getItems() {
        return items;
    }

}
