package laddergame.domain;

import java.util.Collections;
import java.util.List;

public class LadderGame {
    private final Players players;
    private final Ladder ladder;
    private final WinningPrizes winningPrizes;

    public LadderGame(final Players players, final Ladder ladder, final WinningPrizes winningPrizes) {
        this.players = players;
        this.ladder = ladder;
        this.winningPrizes = winningPrizes;
    }

    public GameResult playGame() {
        this.ladder.getLadder().forEach(layer -> evaluateLayerResult(layer));

        return new GameResult(players, winningPrizes);
    }

    private void evaluateLayerResult(final Layer layer) {
        final List<Player> players = this.players.getPlayers();
        for (int order = 0; order < layer.getLayerSize(); order++) {
            swapOrder(layer, players, order);
        }
        giveNewPosition(players);
        this.players.sortPlayersByPosition();
    }

    private void swapOrder(final Layer layer, final List<Player> layerResult, final int order) {
        if (layer.getIndexLink(order)) {
            Collections.swap(layerResult, order, order + 1);
        }
    }

    private void giveNewPosition(final List<Player> layerResult) {
        final int playerCount = layerResult.size();
        for (int i = 0; i < playerCount; i++) {
            layerResult.get(i).move(Position.of(i, playerCount));
        }
    }
}
