package ladder.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class LadderGame {

    private final Names players;
    private final Ladder ladder;
    private final Names rewards;

    private final Map<Name, Name> ladderResult;

    public LadderGame(Names players, Ladder ladder, Names rewards) {
        this.players = players;
        this.ladder = ladder;
        this.rewards = rewards;

        this.ladderResult = generateLadderResult();
    }

    private Map<Name, Name> generateLadderResult() {
        final Map<Name, Name> ladderResult = new HashMap<>();
        for (int i = 0; i < players.findNamesCount(); i++) {
            ladderResult.put(
                players.findNameByIndex(i),
                rewards.findNameByIndex(ladder.followLadder(i)));
        }
        return ladderResult;
    }

    public String findRewardByName(Name playerName) {
        return ladderResult.get(playerName).getValue();
    }

    public Names getPlayers() {
        return players;
    }

    public Names getRewards() {
        return rewards;
    }

    public Ladder getLadder() {
        return ladder;
    }

    public Map<String, String> getLadderResult() {
        return ladderResult.entrySet().stream()
            .collect(Collectors
                .toMap(
                    e -> e.getKey().getValue(),
                    e -> e.getValue().getValue()
                ));
    }
}
