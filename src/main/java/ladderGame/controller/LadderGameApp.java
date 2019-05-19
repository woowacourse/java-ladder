package ladderGame.controller;

import ladderGame.domain.Ladder;
import ladderGame.domain.LadderGame;
import ladderGame.domain.LadderGameResult;
import ladderGame.domain.User;
import ladderGame.view.InputView;
import ladderGame.view.OutputView;

import java.util.List;

public class LadderGameApp {
    private static final String APP_EXIT_NAME = "all";

    public static void main(String[] args) {
        List<User> users = InputView.createUsers();
        List<String> results = InputView.createResults(users.size());
        Ladder ladder = InputView.createLadder(users.size());

        LadderGame ladderGame = new LadderGame(ladder);
        ladderGame.startLadderGame(users);

        OutputView.printLadderUI(users, ladder, results);

        LadderGameResult ladderResult = new LadderGameResult(results, users);
        printResult(ladderResult);
    }

    private static void printResult(LadderGameResult ladderResult) {
        String name = InputView.inputName();
        while (!name.equals(APP_EXIT_NAME)) {
            OutputView.printResult(ladderResult.getResultByName(name));
            name = InputView.inputName();
        }
        OutputView.printResultAll(ladderResult.getResultMap());
    }
}
