package ladder.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import ladder.model.Ladder;
import ladder.model.Line;
import ladder.model.Players;

public class LadderGame {
    private final Players players;
    private final List<String> rewards;
    private final Ladder ladder;

    private LadderGame(Players ladderPlayers, List<String> rewards, Ladder ladder) {
        this.players = ladderPlayers;
        this.rewards = rewards;
        this.ladder = ladder;
    }

    public static LadderGame from(Players ladderPlayers, List<String> rewards, Ladder ladder) {
        return new LadderGame(ladderPlayers, rewards, ladder);
    }

    public Map<String, String> play() {
        List<String> position = new ArrayList<>(players.getPlayerNames());

        for (Line line : ladder.getLadder()) {
            position = line.climbDown(position);
        }
        return createGameResult(position);
    }

    private Map<String, String> createGameResult(List<String> finalPosition) {
        return IntStream.range(0, finalPosition.size())
                .boxed()
                .collect(Collectors.toMap(finalPosition::get, rewards::get));
    }

    public List<String> getPlayerNames() {
        return players.getPlayerNames();
    }

    public List<String> getRewards() {
        return rewards;
    }
}
