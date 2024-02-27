package controller;

import domain.Height;
import domain.Ladder;
import domain.Names;
import domain.RandomBridgeGenerator;
import view.InputView;
import view.OutputView;


public class LadderGame {

    private final InputView inputView = InputView.getInstance();
    private final OutputView outputView = OutputView.getInstance();

    public void start() {
        final Names names = new Names(inputView.readNames());
        final Height height = new Height(inputView.readHeight());

        final RandomBridgeGenerator randomBridgeGenerator = RandomBridgeGenerator.getInstance();
        final Ladder ladder = Ladder.createByStrategy(randomBridgeGenerator, height.getValue(), names.count());

        printGameResult(names, ladder);
    }

    private void printGameResult(final Names names, final Ladder ladder) {
        outputView.printResultMessage();
        outputView.printNames(names.getValues());
        outputView.printLadder(ladder.getLines());
    }
}
