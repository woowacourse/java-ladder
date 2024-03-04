package ladder.controller;

import static ladder.view.InputView.ALL_RESULT_COMMAND;
import static ladder.view.InputView.QUIT_RESULT_COMMAND;

import java.util.List;
import ladder.domain.DirectionGenerator;
import ladder.domain.RandomDirectionGenerator;
import ladder.domain.ResultsOfPlayers;
import ladder.domain.ladder.Height;
import ladder.domain.ladder.Ladder;
import ladder.domain.ladder.Width;
import ladder.domain.player.Players;
import ladder.domain.result.Result;
import ladder.domain.result.Results;
import ladder.exception.ExceptionHandler;
import ladder.view.InputView;
import ladder.view.OutputView;

public class Controller {
    public void run() {
        Players players = createPlayers();
        Results results = createResults(players.count());
        Height height = createHeight();
        Ladder ladder = createLadder(new Width(players.count()), height);

        printOutput(players, ladder, results);
    }

    private static void printOutput(Players players, Ladder ladder, Results results) {
        ResultsOfPlayers resultsOfPlayers = new ResultsOfPlayers(players.climbAllPlayers(ladder), results);
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
        if (QUIT_RESULT_COMMAND.equals(input)) {
            OutputView.printQuitMessage();
            return false;
        }
        if (ALL_RESULT_COMMAND.equals(input)) {
            OutputView.printAllResults(resultsOfPlayers.getResultsOfPlayers());
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

    private Height createHeight() {
        return ExceptionHandler.run(InputView::inputHeight);
    }

    private static Ladder createLadder(Width width, Height height) {
        DirectionGenerator randomDirectionGenerator = new RandomDirectionGenerator();
        return new Ladder(width, height, randomDirectionGenerator);
    }

    private static Results getResults(int playersCount) {
        List<Result> results = InputView.inputResults();
        validateResultsSize(results, playersCount);
        return new Results(results);
    }

    private static void validateResultsSize(List<Result> results, int playersCount) {
        if (results.size() != playersCount) {
            throw new IllegalArgumentException(
                    "실행 결과의 수가 사용자 수와 다릅니다: %d".formatted(results.size())
            );
        }
    }
}
