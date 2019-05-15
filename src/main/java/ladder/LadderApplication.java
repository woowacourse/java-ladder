package ladder;

import ladder.controller.LadderController;
import ladder.view.InputView;

public class LadderApplication {
    public static void main(String[] args){
        LadderController ladderController = new LadderController();
        ladderController.registParticipant(InputView.inputNames());
        ladderController.makeLadder(InputView.inputLadderHeight());

    }
}
