import java.util.Arrays;
import java.util.List;

public class Players {

    private final List<Player> players;

    public Players(String input) {
        this.players = parsePersonName(input);
    }

    public List<Player> parsePersonName(String input) {
        return Arrays.stream(input.split(","))
                .map(name -> new Player(name.trim()))
                .toList();
    }

    public List<Player> getPlayers() {
        return players;
    }
}
