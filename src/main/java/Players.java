import java.util.ArrayList;
import java.util.List;

public class Players {
    private final List<String> players = new ArrayList<>();
    private int count;

    Players(List<String> players) {
        checkPlayerCount(players);
        checkPlayerNameLength(players);
        checkDuplicatePlayers(players);
    }

    private void checkPlayerCount(List<String> players) {
        if (players.size() < 2 || players.size() > 12) {
            throw new IllegalArgumentException();
        }
    }

    private void checkPlayerNameLength(List<String> players){
        if (players.stream()
                .anyMatch(player -> player.length() > 5 || player.replaceAll(" ", "").isEmpty())){
            throw new IllegalArgumentException();
        }
    }

    private void checkDuplicatePlayers(List<String> players) {
        if (!players.stream()
                .distinct().equals(players)) {
            throw new IllegalArgumentException();
        }
    }

}
