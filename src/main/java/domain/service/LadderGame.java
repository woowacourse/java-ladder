package domain.service;

import domain.model.Ladder;
import domain.model.Layer;
import domain.model.Player;

import java.util.List;

public class LadderGame {
    private int maxPosition;
    public LadderGame (final int maxPosition){
        this.maxPosition = maxPosition;
    }
    public LadderGame(){}
    public void playLadderGame(List<Player> players,Ladder ladder){
        players.forEach(player -> {
            ladder.getLayers().forEach(layer->{
                movePlayer(player,layer);
            });
        });
    }
    private void movePlayer(Player player, Layer layer){
        if(player.getPosition() == 0 && layer.getLines().get(0)){
            player.moveRight();
            return;
        }
        if(player.getPosition()==maxPosition && layer.getLines().get(maxPosition-1)){
            player.moveLeft();
            return;
        }
        if(player.getPosition()!=0 && player.getPosition()!=maxPosition) {
            moveNonZeroOrMaxPositionPlayer(player,layer);
        }
    }
    private void moveNonZeroOrMaxPositionPlayer(Player player, Layer layer){
        if (layer.getLines().get(player.getPosition() - 1)) {
            player.moveLeft();
            return;
        }
        if (layer.getLines().get(player.getPosition())){
            player.moveRight();
        }
    }
}
