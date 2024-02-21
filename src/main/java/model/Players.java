package model;

import java.util.List;

public class Players {
    public Players(List<String> players) {
        validate(players);
    }

    private void validate(List<String> players) {
        if(players.size() < 2) {
            throw new IllegalArgumentException();
        }
    }
}
