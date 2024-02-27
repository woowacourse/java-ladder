package controller;

import domain.*;
import view.InputView;
import view.ResultView;

import java.util.HashMap;
import java.util.List;

public class LadderGame {

    private GameResult gameResult;

    public LadderGame() {
        this.gameResult = new GameResult(new HashMap<>());
    }

    public void run() {
        List<String> userNames = InputView.inputUserNames();
        Users users = new Users(userNames);

        List<String> prizes = InputView.inputResults();

        List<Result> results = prizes.stream().map(Result::new).toList();
        Results ladderResults = new Results(results);

        int height = InputView.inputHeight();
        Ladder ladder = new Ladder(height, users.gerPersonCount());

        ResultView.printResultMessage();
        ResultView.printNames(users);
        ResultView.printLadder(ladder);
        ResultView.printResults(ladderResults);
    }

}
