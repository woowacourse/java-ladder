package controller;

import domain.Ladder;
import domain.LadderFactory;
import domain.result.Results;
import domain.user.Users;
import java.util.Arrays;
import view.InputView;
import view.ResultView;

import java.util.List;

public class LadderGame {
    public void run() {
        final Users users = new Users(InputView.inputUserNames());
        final Results results = new Results(InputView.inputResult());
        results.validateSameSizeWithUsers(users);
        final Ladder ladder = LadderFactory.createRandomLadder(InputView.inputHeight(), users.size());

        printLadderWithExtras(users, ladder, results);

        printTargetResult(users, ladder, results);
    }

    private void printLadderWithExtras(final Users users, final Ladder ladder, final Results results) {
        ResultView.printResultMessage();
        ResultView.printNames(Arrays.stream(users.toString().split(",")).toList());
        ResultView.printLadder(ladder);
        ResultView.printNames(Arrays.stream(results.toString().split(",")).toList());
    }

    private static void printTargetResult(final Users users, final Ladder ladder, final Results results) {
        final String target = InputView.inputTargetResult();
        if (target.equals("all")) {
            printAllResult(users, ladder, results);
            return;
        }

        final int endPosition = ladder.play(users.findPositionByName(target));
        ResultView.printTargetResultMessage();
        ResultView.printTargetResult(results.get(endPosition));
    }

    private static void printAllResult(final Users users, final Ladder ladder, final Results results) {
        final List<String> names = Arrays.stream(users.toString().split(",")).toList();
        ResultView.printTargetResult(names,
                names.stream()
                        .map(users::findPositionByName)
                        .map(ladder::play)
                        .map(results::get)
                        .toList());
    }

}
