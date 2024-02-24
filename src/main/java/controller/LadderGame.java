package controller;

import domain.Ladder;
import domain.LadderFactory;
import domain.UserName;
import domain.Users;
import view.InputView;
import view.ResultView;

import java.util.List;

public class LadderGame {
    public void run() {
        final List<String> userNames = InputView.inputUserNames();
        final Users users = new Users(userNames);
        final List<String> results = InputView.inputResult();
        final Ladder ladder = LadderFactory.createRandomLadder(InputView.inputHeight(), users.getPersonCount() - 1);

        printLadderWithExtras(users, ladder, results);

        while (handleTargetResult(users, ladder, results)) {
        }

    }

    private void printLadderWithExtras(final Users users, final Ladder ladder, final List<String> results) {
        ResultView.printResultMessage();
        ResultView.printNames(users.getUsers().stream().map(UserName::toString).toList());
        ResultView.printLadder(ladder);
        ResultView.printNames(results);
    }

    private static boolean handleTargetResult(Users users, Ladder ladder, List<String> results) {
        String target = InputView.inputTargetResult();
        if (target.equals("exit")) {
            return false;
        }
        if (target.equals("all")) {
            ResultView.printTargetResult(List.of());
            return false;
        }
        int startPosition = users.findPositionByName(target);
        int endPosition = ladder.play(startPosition);
        ResultView.printTargetResultMessage();
        ResultView.printTargetResult(results.get(endPosition));
        return true;
    }
}
