package laddergame.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LadderGame {

    public List<Player> playGame(final List<Player> players, final List<Layer> layers) {
        List<Player> gameResult = new ArrayList<>(players);
        layers.forEach(layer -> evaluateLayerResult(gameResult, layer));

        return gameResult;
    }

    public void evaluateLayerResult(final List<Player> players, final Layer layer) {
        for (int i = 0; i < layer.getLayerSize(); i++) {
            swapOrder(layer, players, i);
        }
        giveNewPosition(players);
    }

    private void swapOrder(final Layer layer, final List<Player> layerResult, final int i) {
        if (layer.getIndexLink(i)) {
            Collections.swap(layerResult, i, i + 1);
        }
    }

    private void giveNewPosition(final List<Player> layerResult) {
        final int playerCount = layerResult.size();
        for (int i = 0; i < playerCount; i++) {
            layerResult.get(i).move(Position.of(i, playerCount));
        }
    }
}
