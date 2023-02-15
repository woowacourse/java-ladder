package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Players {
    private List<Player> players = new ArrayList<>();

    public Players(List<String> playerNames) {
        for (String name : playerNames) {
            players.add(new Player(name));
        }
    }
}
