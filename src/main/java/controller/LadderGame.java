package controller;

import domain.*;
import view.InputView;
import view.ResultView;

import java.util.*;

public class LadderGame {

    private static final String ALL = "all";
    private final GameResult gameResult;

    public LadderGame() {
        this.gameResult = new GameResult(new LinkedHashMap<>());
    }

    public void run() {
        List<String> userNames = InputView.inputUserNames();
        Users users = new Users(userNames);

        List<String> prizes = InputView.inputResults();

        List<Result> results = prizes.stream().map(Result::new).toList();
        Results ladderResults = new Results(results);

        int height = InputView.inputHeight();
        Ladder ladder = new Ladder(height, users.gerPersonCount());

        ResultView.printLadderResult();
        ResultView.printNames(users);
        ResultView.printLadder(ladder);
        ResultView.printResults(ladderResults);

        saveToGameResult(ladder, users, ladderResults);

        getFindUserAndPrintPrize();
        getFindUserAndPrintPrize();
    }

    private void getFindUserAndPrintPrize() {
        String findResult = InputView.inputFindResult();
        printPrize(findResult);
    }

    private void saveToGameResult(Ladder ladder, Users users, Results results) {
        List<String> prizeNames = results.getPrizeNames();
        List<String> userNames = users.getUserNames();

        for (int i = 0; i < userNames.size(); i++) {
            int resultIndex = ladder.climb(i);
            gameResult.save(userNames.get(i), prizeNames.get(resultIndex));
        }
    }

    private void printPrize(String findUserName) {
        if (findUserName.equals(ALL)) {
            ResultView.printPrize(gameResult.repository());
            return;
        }
        String prize = gameResult.findByUserName(findUserName);
        ResultView.printPrize(prize);
    }
}
