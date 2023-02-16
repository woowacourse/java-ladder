package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LadderGame {

    private final Players players;

    public LadderGame(List<String> names) {
        List<Player> players = names.stream()
                .map(Player::new)
                .collect(Collectors.toList());

        this.players = new Players(players);
    }

    public List<Line> play(int height) {
        List<Line> result = new ArrayList<>();
        int playerCount = players.size();

        for (int i = 0; i < height; i++) {
            result.add(new Line(playerCount));
        }

        return result;
    }

    public List<String> getPlayerNames() {
        return players.getNames();
    }
}
