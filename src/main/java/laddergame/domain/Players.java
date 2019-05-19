package laddergame.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Players {
    List<Player> players = new ArrayList<>();

    public Players(String playersNames) {
        PlayerNamesValidator.checkConditions(playersNames);

        List<String> names = new ArrayList<>(Arrays.asList(playersNames.split(",")));
        for (String name : names) {
            players.add(new Player(name));
        }
    }

    public int getPeopleCount() {
        return players.size();
    }
}
