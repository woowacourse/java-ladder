package ladder.Controller;

import ladder.domain.*;
import ladder.View.InputView;

import java.util.List;

public class LadderGameManager {
    private List<Line> ladder;

    public void start() {
        InputModel inputModel = new InputModel();
        List<String> names = inputModel.getValidNames(InputView.getNames());

        int ladderHeight = inputModel.getValidLadderHeight(InputView.getLadderHeight());
        Ladder ladder = new Ladder();
        ladder.createLadder(ladderHeight, names.size());


    }
}
