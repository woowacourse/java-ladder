package ladder.view;

import ladder.domain.ladder.Ladder;
import ladder.domain.player.Player;
import ladder.domain.player.Players;
import ladder.domain.reward.Reward;
import ladder.domain.reward.Rewards;

import java.util.Map;

public interface Result {

    void printError(String errorMessage);

    void printLadder(Players players, Ladder ladder, Rewards rewards);

    void printGameResult(Map<Player, Reward> resultByPlayers);
}
