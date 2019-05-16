package ladder.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Players {
    private List<Player> players = new ArrayList<>();

    public Players(String inputName) {
        List<String> names = Arrays.asList(inputName.split(","));
        for (int i = 0; i < names.size(); i++) {
            players.add(new Player(names.get(i), i));
        }
    }

    public List<Player> list() {
        return players;
    }
}
