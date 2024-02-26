package ladder.controller;

import ladder.domain.DirectionGenerator;
import ladder.domain.Height;
import ladder.domain.Ladder;
import ladder.domain.Players;
import ladder.domain.RandomDirectionGenerator;
import ladder.domain.Results;
import ladder.exception.ExceptionHandler;
import ladder.view.InputView;
import ladder.view.OutputView;

public class Controller {

    public void run() {
        Players players = createPlayers();
        Results results = createResults(players.count());
        Height height = createHeight();
        DirectionGenerator directionGenerator = new RandomDirectionGenerator();
        Ladder ladder = new Ladder(players, height, directionGenerator);
        OutputView.printLadderResult(players, ladder, results);
        repeatPrintingIndividualResult(results, ladder);
    }

    private static void repeatPrintingIndividualResult(Results results, Ladder ladder) {
        boolean doRepeat = true;
        while (doRepeat) {
            doRepeat = ExceptionHandler.run(() -> printResultOf(results, ladder));
        }
    }

    private static boolean printResultOf(Results results, Ladder ladder) {
        String input = InputView.inputNameForResult();
        if (input.equals("all")) {
            OutputView.printAllResults(ladder.getAllResultLocation(), results);
            return true;
        }
        if (input.equals("qqqqqq")) {
            OutputView.printQuitMessage();
            return false;
        }
        OutputView.printResultIndividual(results.getResultValue(ladder.getResultLocation(input)));
        return true;
    }

    private Players createPlayers() {
        return ExceptionHandler.run(InputView::inputNames);
    }

    private Results createResults(int playersCount) {
        return ExceptionHandler.run(() -> new Results(InputView.inputResults(), playersCount));
    }

    private Height createHeight() {
        return ExceptionHandler.run(InputView::inputHeight);
    }
}
