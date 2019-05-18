package ladderGame.controller;

import ladderGame.domain.Ladder;
import ladderGame.domain.LadderGame;
import ladderGame.domain.LadderGameResult;
import ladderGame.domain.User;
import ladderGame.util.StringUtil;
import ladderGame.view.InputView;
import ladderGame.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class LadderGameApp {
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

    public static void printResult(LadderGameResult ladderResult) {
        while (true) {
            String name = InputView.inputName();
            OutputView.outputResult(ladderResult.getResultByName(name));
        }
    }
}
