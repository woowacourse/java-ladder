package domain.service;

import domain.model.Ladder;
import domain.model.Layer;
import domain.model.Player;
import domain.model.Players;

public class LadderGame {
    private final Ladder ladder;
    private final Players players;

    public LadderGame(final Ladder ladder, final Players players) {
        this.ladder = ladder;
        this.players = players;
    }

    public void playLadderGame() {
        this.players.getPlayers().forEach(this::movePlayer);
    }

    private void movePlayer(Player player) {
        ladder.getLayers().forEach(layer -> {
            movePlayerOneLayer(player, layer);
        });
    }

    private void movePlayerOneLayer(Player player, Layer layer) {
        int maxPosition = this.ladder.getLineCountInt();
        if (player.getPosition() == 0 && layer.getLines().get(0)) {
            player.moveRight();
            return;
        }
        if (player.getPosition() == maxPosition && layer.getLines().get(maxPosition - 1)) {
            player.moveLeft();
            return;
        }
        if (player.getPosition() != 0 && player.getPosition() != maxPosition) {
            moveNonZeroOrMaxPositionPlayer(player, layer);
        }
    }

    private void moveNonZeroOrMaxPositionPlayer(Player player, Layer layer) {
        if (layer.getLines().get(player.getPosition() - 1)) {
            player.moveLeft();
            return;
        }
        if (layer.getLines().get(player.getPosition())) {
            player.moveRight();
        }
    }

}
