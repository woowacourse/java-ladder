package ladder.controller;

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
        DirectionGenerator directionGenerator = new RandomDirectionGenerator();
        Ladder ladder = new Ladder(players, height, directionGenerator);
        RewardsOfPlayers rewardsOfPlayers = new RewardsOfPlayers(ladder.getAllResultLocation(), results);
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
        if (input.equals("qqqqqq")) {
            OutputView.printQuitMessage();
            return false;
        }
        if (input.equals("all")) {
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
