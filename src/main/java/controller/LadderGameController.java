package controller;

import domain.*;
import utils.RandomGenerator;
import view.InputView;
import view.ResultView;

import java.util.List;
import java.util.Map;

public class LadderGameController {

    private static final String ALL = "all";

    public void run() {
        Users users = generateUsers();
        Results results = generateResults(users.gerPersonCount());
        Ladder ladder = generateLadders(users.gerPersonCount());

        LadderGame ladderGame = new LadderGame(users, ladder, results);
        printLadderResult(users, ladder, results);

        GameResult gameResult = ladderGame.getResult();
        printPrize(gameResult);
    }

    private Users generateUsers() {
        List<String> names = InputView.inputUserNames();
        return new Users(names);
    }

    private Results generateResults(final int personCount) {
        List<String> prizes = InputView.inputResults();
        List<Result> results = prizes.stream().map(Result::new).toList();
        return Results.of(results, personCount);
    }

    private Ladder generateLadders(final int userCount) {
        int height = InputView.inputHeight();
        return Ladder.of(height, userCount, new RandomGenerator());
    }

    private static void printLadderResult(final Users users, final Ladder ladder, final Results ladderResults) {
        ResultView.printLadderResultMessage();
        ResultView.printNames(users);
        ResultView.printLadder(ladder);
        ResultView.printResults(ladderResults);
    }

    private void printPrize(final GameResult gameResult) {
        String findOption = InputView.inputFindOption();
        while (!ALL.equals(findOption)) {
            printSinglePrize(gameResult, findOption);
            findOption = InputView.inputFindOption();
        }
        printAllPrize(gameResult);
    }

    private void printSinglePrize(final GameResult gameResult, final String findUserName) {
        String prize = gameResult.findByUserName(findUserName);
        ResultView.printPrize(prize);
    }

    private void printAllPrize(final GameResult gameResult) {
        Map<String, String> repository = gameResult.repository();
        ResultView.printPrize(repository);
    }
}
