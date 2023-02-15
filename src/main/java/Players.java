import java.util.ArrayList;
import java.util.List;

public class Players {
    private final List<String> players = new ArrayList<>();
    private int count;

    Players(List<String> players) {
        checkPlayerCount(players);
    }

    private void checkPlayerCount(List<String> players) {
        if (players.size() < 2 || players.size() > 12) {
            throw new IllegalArgumentException();
        }
    }

}
