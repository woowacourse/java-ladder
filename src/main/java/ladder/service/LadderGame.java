package ladder.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import ladder.model.Ladder;
import ladder.model.Line;
import ladder.model.Players;

public class LadderGame {
    Players players;
    List<String> rewards;
    Ladder ladder;

    private LadderGame(Players players, List<String> rewards, Ladder ladder) {
        this.players = players;
        this.rewards = rewards;
        this.ladder = ladder;
    }

    public static LadderGame from(Players players, List<String> rewards, Ladder ladder) {
        return new LadderGame(players, rewards, ladder);
    }

    public Map<String, String> play() {
        List<Integer> position = new ArrayList<>(
                IntStream.range(0, players.getSize())
                        .boxed()
                        .toList()
        );

        for (Line line : ladder.getLadder()) {
            position = clacIndexAfterClimbDownOneLine(position, line);
        }

        List<String> playerNames = players.getPlayerNames();
        List<String> resName = position.stream()
                .map(playerNames::get)
                .toList();
        return IntStream.range(0, players.getSize())
                .boxed()
                .collect(Collectors.toMap(
                        resName::get,
                        rewards::get
                ));
    }

    public List<Integer> clacIndexAfterClimbDownOneLine(List<Integer> initialPosition, Line line) {
        List<Boolean> isConnected = line.getConnected();
        List<Integer> connectedIndices = IntStream.range(0, isConnected.size())
                .filter(isConnected::get)
                .boxed()
                .toList();

        for (int connectedIndex : connectedIndices) {
            Collections.swap(initialPosition, connectedIndex, connectedIndex+1);
        }

        return initialPosition;
    }
}
