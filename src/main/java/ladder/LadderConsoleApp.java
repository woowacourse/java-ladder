package ladder;

import ladder.controller.LadderGameController;
import ladder.domain.GamePlayers;
import ladder.domain.Ladder;
import ladder.domain.PlayerGenerator;
import ladder.view.OutputConsoleView;

public class LadderConsoleApp {
    public static void main(String[] args) {
        LadderGameController ladderGameController = new LadderGameController();
        ladderGameController.run();
    }
}
