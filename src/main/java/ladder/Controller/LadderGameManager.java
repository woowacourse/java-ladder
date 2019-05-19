package ladder.Controller;

import ladder.domain.*;
import ladder.View.InputView;

import java.util.List;

public class LadderGameManager {

    public void start() {
        InputModel inputModel = new InputModel();
        List<String> names = inputModel.getValidNames(InputView.getNames());

        int ladderHeight = inputModel.getValidLadderHeight(InputView.getLadderHeight());
    }
}
