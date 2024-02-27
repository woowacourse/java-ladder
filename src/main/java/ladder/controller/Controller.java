package ladder.controller;

import static ladder.view.InputView.ALL_RESULT_COMMAND;
import static ladder.view.InputView.QUIT_RESULT_COMMAND;

import ladder.domain.DirectionGenerator;
import ladder.domain.Height;
import ladder.domain.Ladder;
import ladder.domain.Players;
import ladder.domain.RandomDirectionGenerator;
import ladder.domain.Results;
import ladder.domain.RewardsOfPlayers;
import ladder.exception.ExceptionHandler;
import ladder.view.InputView;
import ladder.view.OutputView;

public class Controller {
    public void run() {
        Players players = createPlayers();
        Results results = createResults(players.count());
        Height height = createHeight();
        DirectionGenerator randomDirectionGenerator = new RandomDirectionGenerator();
        Ladder ladder = new Ladder(players, height, randomDirectionGenerator);
        RewardsOfPlayers rewardsOfPlayers = new RewardsOfPlayers(ladder.getResultPlayers(), results);
        OutputView.printLadderResult(players, ladder, results);
        repeatPrintingReward(rewardsOfPlayers);
    }

    private static void repeatPrintingReward(RewardsOfPlayers rewardsOfPlayers) {
        boolean doRepeat = true;
        while (doRepeat) {
            doRepeat = ExceptionHandler.run(() -> inputNameAndPrintReward(rewardsOfPlayers));
        }
    }

    private static boolean inputNameAndPrintReward(RewardsOfPlayers rewardsOfPlayers) {
        String input = InputView.inputNameForResult();
        return printRewardOf(rewardsOfPlayers, input);
    }

    private static boolean printRewardOf(RewardsOfPlayers rewardsOfPlayers, String input) {
        if (input.equals(QUIT_RESULT_COMMAND)) {
            OutputView.printQuitMessage();
            return false;
        }
        if (input.equals(ALL_RESULT_COMMAND)) {
            OutputView.printAllRewards(rewardsOfPlayers.getAllRewards());
            return true;
        }
        OutputView.printRewardIndividual(rewardsOfPlayers.getRewardByName(input));
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
