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
        final PlayerResults playerResults = PlayerResults.of(names, ladder, results);

        outputView.printLadderResult(names, ladder, results);
        printPlayerResultsUntilTerminate(playerResults);
    }

    private void printPlayerResultsUntilTerminate(final PlayerResults playerResults) {
        String target = inputView.readTarget();
        while (!Commands.isTerminate(target)) {
            Result result = playerResults.findResult(target);
            outputView.printResult(result);
            target = inputView.readTarget();
        }
        outputView.printPlayerResult(playerResults.getPlayerResults());
    }
}
