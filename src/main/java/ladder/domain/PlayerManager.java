package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class PlayerManager {
    private List<Player> players;

    public PlayerManager(List<String> names,Line line) {
        createPlayers(names,line);
    }
    public List<Player> createPlayers(List<String> names, Line line) {
        players = new ArrayList<>();
        for (int i =0; i<names.size(); i++) {
            if(i==0) {
                players.add(new Player(names.get(i), players.size(), new Direction(false, line.getRowLines().get(i))));
            }
            else if(i == (names.size()-1)) {
                players.add(new Player(names.get(i), players.size(), new Direction(line.getRowLines().get(i - 1),false)));
            }
            else {
                players.add(new Player(names.get(i), players.size(), new Direction(line.getRowLines().get(i - 1), line.getRowLines().get(i))));
            }
        }

        return players;
    }

    public List<Player> getPlayers() {
        return players;
    }

}