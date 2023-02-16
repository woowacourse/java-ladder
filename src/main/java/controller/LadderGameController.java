package controller;

import domain.Ladder;
import domain.Name;
import domain.Names;
import dto.GameDto;
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
        Ladder ladder = new Ladder(new RandomBooleanGenerator());
        ladder.build(height, names.count());
        return ladder;
    }

    private static void printResult(final Names names, final Ladder ladder) {
        OutputView.printResult(new GameDto(names, ladder));
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
