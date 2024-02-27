package controller;

import domain.*;
import view.InputView;
import view.ResultView;

import java.util.*;

public class LadderGame {

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

        String findUserName = InputView.inputFindResult();
        ResultView.findPrize(findResult(findUserName));

        String findUserName2 = InputView.inputFindResult();
        ResultView.findPrize(findResult(findUserName2));
    }

    private void saveToGameResult(Ladder ladder, Users users, Results results) {
        List<String> prizeNames = results.getPrizeNames();
        List<String> userNames = users.getUserNames();

        for (int i = 0; i < userNames.size(); i++) {
            int resultIndex = ladder.climb(i);
            gameResult.save(userNames.get(i), prizeNames.get(resultIndex));
        }
    }

    private String findResult(String findUserName) {
        if (findUserName.equals("all")) {
            return findAllResult();
        }

        return gameResult.findByUserName(findUserName);
    }

    private String findAllResult() {
        StringBuilder stringBuilder = new StringBuilder();

        Map<String, String> repository = gameResult.getRepository();
        for (Map.Entry<String, String> entry : repository.entrySet()) {
            stringBuilder.append(entry.getKey())
                    .append(" : ")
                    .append(entry.getValue())
                    .append("\n");
        }
        return stringBuilder.toString();
    }

}
