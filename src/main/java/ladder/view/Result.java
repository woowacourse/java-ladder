package ladder.view;

import ladder.domain.ladder.Ladder;
import ladder.domain.player.Players;

public interface Result {

    void printError(String errorMessage);

    void printLadder(Players players, Ladder ladder);

}
