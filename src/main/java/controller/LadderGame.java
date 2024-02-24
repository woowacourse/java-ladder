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

        printTargetResult(users, ladder, results);
    }

    private void printLadderWithExtras(final Users users, final Ladder ladder, final List<String> results) {
        ResultView.printResultMessage();
        ResultView.printNames(users.getUsers().stream().map(UserName::toString).toList());
        ResultView.printLadder(ladder);
        ResultView.printNames(results);
    }

    private static void printTargetResult(final Users users, final Ladder ladder, final List<String> results) {
        final String target = InputView.inputTargetResult();
        if (target.equals("all")) {
            printAllResult(users, ladder, results);
            return;
        }
        final int endPosition = ladder.playByPosition(users.findPositionByName(target));
        ResultView.printTargetResultMessage();
        ResultView.printTargetResult(results.get(endPosition));
    }

    private static void printAllResult(final Users users, final Ladder ladder, final List<String> results) {
        final List<String> names = users.getUsers().stream().map(UserName::toString).toList();
        ResultView.printTargetResult(names,
                names.stream()
                        .map(users::findPositionByName)
                        .map(ladder::playByPosition)
                        .map(results::get)
                        .toList());
    }
}
