package controller;

import domain.model.Goods;
import domain.model.Ladder;
import domain.model.Players;

public class Request {
    private final Players players;
    private final Goods goods;
    private final Ladder ladder;

    public Request(final Players players, final Goods goods, final Ladder ladder) {
        this.players = players;
        this.goods = goods;
        this.ladder = ladder;
    }

    public Request(final Players players, final Goods goods) {
        this.players = players;
        this.goods = goods;
        this.ladder = null;
    }

    public Players getPlayers() {
        return this.players;
    }

    public Goods getGoods() {
        return this.goods;
    }

    public Ladder getLadder() {
        return this.ladder;
    }
}
