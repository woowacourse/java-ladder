package domain.service;

import domain.model.Ladder;
import domain.model.Layer;
import domain.model.Player;
import domain.vo.Name;

import java.util.List;

public class LadderGame {
    private int maxPosition;
    private List<Player> players;
    public LadderGame(final int maxPosition) {
        this.maxPosition = maxPosition;
    }

    public void playLadderGame(List<Name> playersName, Ladder ladder) {
        players = new PlayerMaker(playersName).getPlayerList();
        players.forEach(player -> {
            movePlayer(ladder, player);
        });
    }

    private void movePlayer(Ladder ladder, Player player) {
        ladder.getLayers().forEach(layer -> {
            movePlayerOneLayer(player, layer);
        });
    }

    private void movePlayerOneLayer(Player player, Layer layer) {
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
    public List<Player> getPlayers(){
        return this.players;
    }
}
