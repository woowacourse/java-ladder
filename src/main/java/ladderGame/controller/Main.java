package ladderGame.controller;

import ladderGame.domain.LadderGame;
import ladderGame.domain.Result;
import ladderGame.domain.User;
import ladderGame.util.StringUtil;
import ladderGame.view.InputView;
import ladderGame.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String names = InputView.inputNames();
        List<User> users = createUser(names);

        String inputResults = InputView.inputResults();
        List<String> results = StringUtil.splitComma(inputResults);

        int height = InputView.inputLadderHeight();
        LadderGame ladderGame =  new LadderGame(height);
        ladderGame.createLadder(users);
        ladderGame.startLadderGame(users);

        OutputView.outputNames(users);
        OutputView.outputLadder(ladderGame.getLadder());
        OutputView.outputResults(results);

        Result result = new Result(results, users);
        String name = InputView.inputName();
        OutputView.outputResult(result.getResultByName(name));
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
