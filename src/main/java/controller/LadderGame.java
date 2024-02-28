package controller;

import domain.*;
import view.InputView;
import view.OutputView;


public class LadderGame {

    private final InputView inputView = InputView.getInstance();
    private final OutputView outputView = OutputView.getInstance();

    public void start() {
        final Names names = new Names(inputView.readNames());
        final Results results = Results.of(inputView.readResults(), names.count());
        final Height height = new Height(inputView.readHeight());

        final RandomBridgeGenerator randomBridgeGenerator = RandomBridgeGenerator.getInstance();
        final Ladder ladder = Ladder.createByStrategy(randomBridgeGenerator, height.getValue(), names.count());

        printGameResult(names, ladder, results);

        PlayerResults playerResults = PlayerResults.of(names, ladder, results);
        while (true) {
            String target = inputView.readTarget();
            if (target.equals("all")) {
                for (final Name name : names.getValues()) {
                    outputView.printPlayerResult(name.getValue(), playerResults.findResult(name.getValue()).getValue());
                }
                break;
            }
            outputView.printResult(playerResults.findResult(target).getValue());
        }
    }

    private void printGameResult(final Names names, final Ladder ladder, final Results results) {
        outputView.printLadderResultMessage();
        outputView.printNames(names.getValues());
        outputView.printLadder(ladder.getLines());
        outputView.printResults(results.getValues());
    }
}
