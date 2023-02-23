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

    public void evaluateLayerResult(final List<Player> players, final Layer layer) {
        for (int i = 0; i < layer.getLayerSize(); i++) {
            swapOrder(layer, players, i);
        }
        giveNewPosition(players);
    }


    private static void swapOrder(final Layer layer, final List<Player> layerResult, final int i) {
        if (layer.getIndexLink(i)) {
            Collections.swap(layerResult, i, i + 1);
        }
    }

    private static void giveNewPosition(final List<Player> layerResult) {
        final int playerCount = layerResult.size();
        for (int i = 0; i < playerCount; i++) {
            layerResult.get(i).move(new Position(i, playerCount));
        }
    }
}
