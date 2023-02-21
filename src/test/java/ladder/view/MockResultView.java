package ladder.view;

import ladder.domain.ladder.Ladder;
import ladder.domain.ladder.Line;
import ladder.domain.player.Player;
import ladder.domain.player.Players;
import ladder.domain.reward.Reward;
import ladder.domain.reward.Rewards;

import java.util.List;
import java.util.Map;

public class MockResultView implements Result{

    private List<String> players;
    private List<Line> ladder;

    private Boolean hasError;

    @Override
    public void printError(String errorMessage) {
        this.hasError = true;
    }

    @Override
    public void printLadder(Players players, Ladder ladder, Rewards rewards) {
        this.players = players.getNames();
        this.ladder = ladder.getLadder();
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

    @Override
    public void printGameResult(Map<Player, Reward> resultByPlayers) {

    }
}
