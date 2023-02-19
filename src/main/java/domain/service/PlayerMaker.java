package domain.service;

import domain.model.Player;
import domain.vo.Name;
import domain.vo.Position;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PlayerMaker {
    private final List<Player> playerList;
    public PlayerMaker(String players){
        playerList = new ArrayList<>();
        makePlayerList(List.of(players.split(",")));
    }
    private void makePlayerList(List<String> players){
        for (int i = 0; i < players.size(); i++) {
            playerList.add(new Player(new Name(players.get(i)),new Position(i)));
        }
    }
    public List<Player> getPlayerList(){
        return playerList;
    }
}
