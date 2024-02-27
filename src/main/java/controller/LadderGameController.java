package controller;

import domain.*;
import view.InputView;
import view.ResultView;

import java.util.List;
import java.util.Map;

public class LadderGameController {

    private static final String ALL = "all";

    public void run() {
        Users users = generateUsers();
        Results results = generateResults();
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

    private Results generateResults() {
        List<String> prizes = InputView.inputResults();
        List<Result> results = prizes.stream().map(Result::new).toList();
        return new Results(results);
    }

    private Ladder generateLadders(int userCount) {
        int height = InputView.inputHeight();
        return new Ladder(height, userCount);
    }

    private static void printLadderResult(Users users, Ladder ladder, Results ladderResults) {
        ResultView.printLadderResultMessage();
        ResultView.printNames(users);
        ResultView.printLadder(ladder);
        ResultView.printResults(ladderResults);
    }

    private void printPrize(GameResult gameResult) {
        String findOption = InputView.inputFindOption();
        while (!ALL.equals(findOption)) {
            printSinglePrize(gameResult, findOption);
            findOption = InputView.inputFindOption();
        }
        printAllPrize(gameResult);
    }

    private void printSinglePrize(GameResult gameResult, String findUserName) {
        String prize = gameResult.findByUserName(findUserName);
        ResultView.printPrize(prize);
    }

    private void printAllPrize(GameResult gameResult) {
        Map<String, String> repository = gameResult.repository();
        ResultView.printPrize(repository);
    }
}
