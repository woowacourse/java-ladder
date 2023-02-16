package ladder.controller;

import ladder.domain.Ladder;
import ladder.domain.NamesSplitor;
import ladder.domain.RandomBasedBarGenerator;
import ladder.view.InputView;
import ladder.view.OutputView;

import java.util.List;

public class LadderController {
    public void run() {
        List<String> names = InputView.repeat(() -> NamesSplitor.split(InputView.inputPeopleNames()));
        int ladderHeight = InputView.repeat(InputView::inputLadderHeight);

        Ladder ladder = new Ladder(new RandomBasedBarGenerator(), ladderHeight, names.size());

        OutputView.printNames(names);
        OutputView.printLadder(ladder, names.get(0).length());
    }
}
