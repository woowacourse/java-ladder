package ladderGame.controller;

import ladderGame.domain.LadderGame;
import ladderGame.domain.Result;
import ladderGame.domain.User;
import ladderGame.util.StringUtil;
import ladderGame.view.InputCheck;
import ladderGame.view.InputView;
import ladderGame.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String names = InputView.inputNames();
        List<User> users = createUser(names);

        int height = InputView.inputLadderHeight();
        LadderGame ladderGame =  new LadderGame(height);

        String inputResults = InputView.inputResults();
        List<String> results = StringUtil.splitComma(inputResults);

        OutputView.outputNames(users);
        ladderGame.createLadder(users);
        OutputView.outputLadder(ladderGame.getLadder());
        OutputView.outputResult(results);

        ladderGame.startLadderGame(users);

        String name;

        do {
            name = InputView.inputNames1();
            OutputView.output(name, users, results);
        } while (!name.equals("all"));
        OutputView.outputAll(users, results);
    }

    private static List<User> createUser(String inputNames) {
        List<User> users = new ArrayList<>();
        List<String> names = StringUtil.splitComma(inputNames);
        for (int i = 0; i < names.size(); i++) {
            users.add(new User(names.get(i), i));
        }
        return users;
    }
}
