package laddergame.domain;

import laddergame.domain.rule.Rule;
import laddergame.util.Validator;

import java.util.HashMap;
import java.util.Map;

public class LadderGame {
    private Ladder ladder;

    public LadderGame(int numberOfPlayers, int height, Rule rule) {
        Validator.checkLadderHeight(height);

        ladder = new Ladder(numberOfPlayers, height, rule);
    }

    public Ladder getLadder() {
        return ladder;
    }

    public LadderGameResult startGame(Players players, Rewards rewards) {
        Validator.checkEqualSize(players.size(), rewards.size());

        Map<Player, Reward> result = new HashMap<>();
        for (int i = 0; i < players.size(); i++) {
            result.put(players.get(i), rewards.get(ladder.takeLadder(i)));
        }
        return new LadderGameResult(result);
    }
}
