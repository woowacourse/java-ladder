package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LadderGame {
    private final static String ALL_RESULT = "all";
    private final Players players;
    private final Ladder ladder;

    public LadderGame(Players players, Ladder ladder) {
        this.players = players;
        this.ladder = ladder;
    }

    public List<String> getResult(String name, Prizes prizes) {
        if (name.equals(ALL_RESULT)) {
            return players.getNames().stream()
                    .map(this::getResultIndex)
                    .map(prizes::getName)
                    .collect(Collectors.toList());
        }
        return List.of(prizes.getName(getResultIndex(name)));
    }

    private int getResultIndex(String name) {
        int playerIndex = players.getOrder(name);
        Position position = new Position(playerIndex);
        for (Line line : ladder.getLines()) {
            ladder.move(line, position);
        }
        return position.getIndex();
    }

}
