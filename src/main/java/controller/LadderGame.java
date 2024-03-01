package controller;

import domain.Ladder;
import domain.LadderFactory;
import domain.result.Result;
import domain.result.Results;
import domain.user.Users;
import java.util.Arrays;
import view.InputView;
import view.ResultView;

import java.util.List;

public class LadderGame {
    public void run() {
        final Users users = Users.fromNames(InputView.inputUserNames());
        final Results results = Results.fromNames(InputView.inputResult());
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
        ResultView.printTargetResult(results.get(endPosition).toString());
    }

    private static void printAllResult(final Users users, final Ladder ladder, final Results results) {
        final List<String> userNames = Arrays.stream(users.toString().split(",")).toList();
        final List<String> resultNames = userNames.stream()
                .map(users::findPositionByName)
                .map(ladder::play)
                .map(results::get)
                .map(Result::toString)
                .toList();
        ResultView.printTargetResult(userNames, resultNames);
    }

}
