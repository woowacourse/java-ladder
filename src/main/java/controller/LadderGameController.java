package controller;

import domain.Height;
import domain.Ladder;
import domain.Names;
import util.BooleanGenerator;
import view.InputView;
import view.OutputView;

public class LadderGameController {

    private final BooleanGenerator booleanGenerator;
    private final InputView inputView;
    private final OutputView outputView;

    public LadderGameController(BooleanGenerator booleanGenerator, InputView inputView, OutputView outputView) {
        this.booleanGenerator = booleanGenerator;
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        Names names = getNames();
        Height height = getHeight();

        Ladder ladder = buildLadder(names, height);

        printResult(names, ladder);
    }

    private Ladder buildLadder(final Names names, final Height height) {
        Ladder ladder = Ladder.of(booleanGenerator);
        ladder.build(height, names.count());
        return ladder;
    }

    private void printResult(final Names names, final Ladder ladder) {
        outputView.printResult(names, ladder);
    }

    private Names getNames() {
        try {
            outputView.printRequestNames();
            return Names.ofValues(inputView.getNames());
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e.getMessage());
            return getNames();
        }
    }

    private Height getHeight() {
        try {
            outputView.printRequestLadderHeight();
            return Height.of(inputView.getHeight());
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e.getMessage());
            return getHeight();
        }
    }
}
