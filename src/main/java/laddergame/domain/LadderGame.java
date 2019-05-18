package laddergame.domain;

import laddergame.domain.rule.Rule;
import laddergame.util.Validator;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LadderGame {
    private Ladder ladder;
    private List<Player> players;
    private List<Reward> rewards;

    public LadderGame(List<String> playerNames, List<String> rewardsNames, int height, Rule rule) {
        Validator.checkEqualSize(playerNames.size(), rewardsNames.size());
        Validator.checkDuplicateNames(playerNames);

        players = playerNames.stream()
                .map(Player::new)
                .collect(Collectors.toList());
        rewards = rewardsNames.stream()
                .map(Reward::new)
                .collect(Collectors.toList());
        ladder = LadderGenerator.generateLadder(playerNames.size(), height, rule);
    }

    public Ladder getLadder() {
        return ladder;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public List<Reward> getRewards() {
        return rewards;
    }

    public LadderGameResult startGame() {
        Map<Player, Reward> result = new HashMap<>();
        for (int i = 0; i < players.size(); i++) {
            result.put(players.get(i), rewards.get(ladder.takeLadder(i)));
        }
        return new LadderGameResult(result);
    }
}
