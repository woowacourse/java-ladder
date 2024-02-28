package ladder.controller;

import static ladder.view.InputView.ALL_RESULT_COMMAND;
import static ladder.view.InputView.QUIT_RESULT_COMMAND;

import java.util.List;
import ladder.domain.DirectionGenerator;
import ladder.domain.Height;
import ladder.domain.Ladder;
import ladder.domain.Players;
import ladder.domain.RandomDirectionGenerator;
import ladder.domain.Results;
import ladder.domain.ResultsOfPlayers;
import ladder.domain.Width;
import ladder.exception.ExceptionHandler;
import ladder.view.InputView;
import ladder.view.OutputView;

public class Controller {
    public void run() {
        Players players = createPlayers();
        Results results = createResults(players.count());
        Height height = createHeight();

        Width width = new Width(players.count());
        DirectionGenerator randomDirectionGenerator = new RandomDirectionGenerator();
        Ladder ladder = new Ladder(width, height, randomDirectionGenerator);

        ResultsOfPlayers resultsOfPlayers = new ResultsOfPlayers(players, ladder, results);
        OutputView.printLadderResult(players, ladder, results);
        repeatPrintingReward(resultsOfPlayers);
    }

    private static void repeatPrintingReward(ResultsOfPlayers resultsOfPlayers) {
        boolean doRepeat = true;
        while (doRepeat) {
            doRepeat = ExceptionHandler.run(() -> inputNameAndPrintReward(resultsOfPlayers));
        }
    }

    private static boolean inputNameAndPrintReward(ResultsOfPlayers resultsOfPlayers) {
        String input = InputView.inputNameForResult();
        return printRewardOf(resultsOfPlayers, input);
    }

    private static boolean printRewardOf(ResultsOfPlayers resultsOfPlayers, String input) {
        if (input.equals(QUIT_RESULT_COMMAND)) {
            OutputView.printQuitMessage();
            return false;
        }
        if (input.equals(ALL_RESULT_COMMAND)) {
            OutputView.printAllResults(resultsOfPlayers.getAllResults());
            return true;
        }
        OutputView.printResult(resultsOfPlayers.getResultByName(input));
        return true;
    }

    private Players createPlayers() {
        return ExceptionHandler.run(InputView::inputNames);
    }

    private Results createResults(int playersCount) {
        return ExceptionHandler.run(() -> getResults(playersCount));
    }

    private static Results getResults(int playersCount) {
        List<String> results = InputView.inputResults();
        validateResultsSize(results, playersCount);
        return new Results(results);
    }

    private static void validateResultsSize(List<String> results, int playersCount) {
        if (results.size() != playersCount) {
            throw new IllegalArgumentException(
                    "실행 결과의 수가 사용자 수와 다릅니다: %d".formatted(results.size())
            );
        }
    }

    private Height createHeight() {
        return ExceptionHandler.run(InputView::inputHeight);
    }
}
