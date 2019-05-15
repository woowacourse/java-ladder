package ladder;

import ladder.controller.GameController;
import ladder.view.InputView;
import ladder.view.OutputView;

public class GameApplication {
    public static void main(String[] args){
        GameController ladderController = new GameController();
        ladderController.registParticipant(InputView.inputNames());
        ladderController.makeLadder(InputView.inputLadderHeight());
        OutputView.printLadderResult(ladderController.getLadder(),ladderController.getParticipants());
    }
}
