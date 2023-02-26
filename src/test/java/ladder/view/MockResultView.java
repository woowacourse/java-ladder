package ladder.view;

import ladder.domain.ladder.Ladder;
import ladder.domain.ladder.Line;
import ladder.domain.player.Player;
import ladder.domain.player.Players;
import ladder.domain.reward.Reward;
import ladder.domain.reward.Rewards;

import java.util.List;
import java.util.Map;

public class MockResultView implements Result {

    private List<String> players;
    private List<Line> ladder;
    private List<Reward> rewards;
    private Map<Player, Reward> gameResult;
    private Boolean hasError;

    @Override
    public void printError(String errorMessage) {
        this.hasError = true;
    }

    @Override
    public void printLadder(Players players, Ladder ladder, Rewards rewards) {
        this.players = players.getNames();
        this.ladder = ladder.getLadder();
        this.rewards = rewards.getRewards();
    }

    @Override
    public void printGameResult(Map<Player, Reward> gameResult) {
        this.gameResult = gameResult;
    }

    public Boolean hasError() {
        return hasError;
    }

    public List<String> getPlayers() {
        return players;
    }

    public List<Line> getLadder() {
        return ladder;
    }

    public List<Reward> getRewards() {
        return rewards;
    }

    public Map<Player, Reward> getGameResult() {
        return gameResult;
    }

}
