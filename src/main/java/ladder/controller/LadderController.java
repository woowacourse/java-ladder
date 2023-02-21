package ladder.controller;

import ladder.domain.Ladder;
import ladder.domain.Names;
import ladder.domain.RandomBasedBarGenerator;
import ladder.view.InputView;
import ladder.view.OutputView;

import java.util.List;

public class LadderController {

    public void run() {
        Names names = InputView.repeat(() -> new Names(InputView.inputPeopleNames()));
        List<String> namesList = names.getNames();
        int ladderHeight = InputView.repeat(InputView::inputLadderHeight);

        Ladder ladder = new Ladder(new RandomBasedBarGenerator(), ladderHeight, namesList.size());

        printResult(ladder, namesList);
    }

    private void printResult(Ladder ladder, List<String> namesList) {
        OutputView.printNames(namesList);
        OutputView.printLadder(ladder, namesList.get(0).length());
    }
}
