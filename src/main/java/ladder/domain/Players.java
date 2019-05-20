package ladder.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Players {
    private static final String SPLIT_SEPARATOR = ",";

    private final List<Player> players;

    public Players(String input) {
        this.players = addPlayer(splitNames(input));
    }

    private static String[] splitNames(String names) {
        return names.split(SPLIT_SEPARATOR);
    }

    private List<Player> addPlayer(String[] names) {
        List<Player> players = new ArrayList<>();
        Arrays.stream(names)
                .forEach(name -> players.add(new Player(name)));
        return players;
    }

    public int getCount() {
        return players.size();
    }

    public List<Player> getPlayers() {
        return this.players;
    }

    public Player getPlayer(int index) {
        return this.players.get(index);
    }
}
