package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LadderGame {

    private final List<Name> players;

    public LadderGame(List<String> players) {
        this.players = players.stream()
                .map(Name::new)
                .collect(Collectors.toList());
    }

    public List<Line> play(int height) {
        List<Line> result = new ArrayList<>();
        int playerCount = players.size();

        for (int i = 0; i < height; i++) {
            result.add(new Line(playerCount));
        }

        return result;
    }
}
