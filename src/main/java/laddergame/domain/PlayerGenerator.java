package laddergame.domain;

import java.util.ArrayList;
import java.util.List;

public class PlayerGenerator {
    public static List<Player> createPlayer(String input) {
        List<String> names = PlayerNames.makeNames(input);
        List<Player> players = new ArrayList<>();

        for (String name : names) {
            players.add(new Player(name));
        }

        return players;
    }
}
