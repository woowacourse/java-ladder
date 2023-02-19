package ladder.controller;

import ladder.domain.Ladder;
import ladder.domain.PlayerNames;
import ladder.domain.RandomBasedBarGenerator;
import ladder.view.InputView;
import ladder.view.OutputView;

public class LadderController {
    public void run() {
        PlayerNames playerNames = InputView.repeat(() -> new PlayerNames(InputView.inputPeopleNames()));
        int ladderHeight = InputView.repeat(InputView::inputLadderHeight);
        
        Ladder ladder = new Ladder(new RandomBasedBarGenerator(), ladderHeight, playerNames.playerSize());
        
        OutputView.printNames(playerNames);
        OutputView.printLadder(ladder, playerNames.firstPlayerNameLength());
    }
}
