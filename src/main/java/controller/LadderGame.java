package controller;

import domain.*;
import view.InputView;
import view.OutputView;

import java.util.Map;


public class LadderGame {

    private final InputView inputView = InputView.getInstance();
    private final OutputView outputView = OutputView.getInstance();

    public void start() {
        final Names names = new Names(inputView.readNames());
        final Results results = Results.of(inputView.readResults(), names.count());
        final Height height = new Height(inputView.readHeight());
        final RandomBridgeGenerator randomBridgeGenerator = RandomBridgeGenerator.getInstance();
        final Ladder ladder = Ladder.createByStrategy(randomBridgeGenerator, height.getValue(), names.count());
        final PlayerResults playerResults = PlayerResults.of(names, ladder, results);

        printLadderResult(names, ladder, results);
        printPlayerResultsUntilTerminate(playerResults);
    }

    private void printLadderResult(final Names names, final Ladder ladder, final Results results) {
        outputView.printLadderResultMessage();
        outputView.printNames(names.getValues());
        outputView.printLadder(ladder.getLines());
        outputView.printResults(results.getValues());
    }

    private void printPlayerResultsUntilTerminate(final PlayerResults playerResults) {
        String target = inputView.readTarget();
        while (!Commands.terminate(target)) {
            printTargetPlayerResult(playerResults, target);
            target = inputView.readTarget();
        }
        printAllPlayerResults(playerResults);
    }

    private void printTargetPlayerResult(final PlayerResults playerResults, final String target) {
        outputView.printPlayerResultMessage();
        outputView.printResult(playerResults.findResult(target).getValue());
    }

    private void printAllPlayerResults(final PlayerResults playerResults) {
        outputView.printPlayerResultMessage();
        for (final Map.Entry<Name, Result> entry : playerResults.getPlayerResults().entrySet()) {
            outputView.printPlayerResult(entry.getKey().getValue(),entry.getValue().getValue());
        }
    }

}
