package controller;

import domain.Ladder;
import domain.LadderFactory;
import domain.Users;
import view.InputView;
import view.ResultView;

import java.util.List;

public class LadderGame {
    public void run() {
        final List<String> userNames = InputView.inputUserNames();
        final Users users = new Users(userNames);
        final List<String> results = InputView.inputResult();
        final Ladder ladder = LadderFactory.createRandomLadder(InputView.inputHeight(), users.getPersonCount());

        printLadderWithExtras(users, ladder, results);

        handleTargetResult();
    }

    private static void handleTargetResult() {
        InputView.inputTargetResult();
        ResultView.printTargetResultMessage();
        ResultView.printTargetResult("");
    }

    private void printLadderWithExtras(final Users users, final Ladder ladder, final List<String> results) {
        ResultView.printResultMessage();
        ResultView.printNames(users);
        ResultView.printLadder(ladder);
        ResultView.printResult(results);
    }
}
