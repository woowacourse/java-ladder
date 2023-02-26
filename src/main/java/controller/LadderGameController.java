package controller;

import domain.Ladder.Ladder;
import domain.Ladder.LadderGenerator;
import domain.Name;
import domain.Names;
import util.RandomBooleanGenerator;
import view.InputView;
import view.OutputView;

public class LadderGameController {

    public void run() {
        Names names = getNames();
        int height = getHeight();

        Ladder ladder = buildLadder(names, height);

        printResult(names, ladder);
    }

    private Ladder buildLadder(final Names names, final int height) {
        return new LadderGenerator(new RandomBooleanGenerator()).build(height, names.count());
    }

    private static void printResult(final Names names, final Ladder ladder) {
        OutputView.printResult(names, ladder);
    }


    private Names getNames() {
        try {
            OutputView.printRequestNames();
            return new Names(Name.of(InputView.getNames()));
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            return getNames();
        }
    }

    private int getHeight() {
        try {
            OutputView.printRequestLadderHeight();
            return InputView.getHeight();
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            return getHeight();
        }
    }
}
