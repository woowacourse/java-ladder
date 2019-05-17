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

public class Main {
    public static void main(String[] args) {
        List<User> users = createUsers();
        List<String> results = createResults(users.size());
        Ladder ladder = createLadder(users.size());

        LadderGame ladderGame = new LadderGame(ladder);
        ladderGame.startLadderGame(users);

        OutputView.printLadderUI(users, ladder, results);

        LadderGameResult ladderResult = new LadderGameResult(results, users);
        printResult(ladderResult);
    }

    private static List<User> createUsers() {
        try {
            String names = InputView.inputNames();
            return createUsers(names);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return createUsers();
        }
    }

    private static List<User> createUsers(String inputNames) {
        List<User> users = new ArrayList<>();
        List<String> names = StringUtil.splitComma(inputNames);

        for (int i = 0; i < names.size(); i++) {
            users.add(new User(names.get(i), i));
        }
        return users;
    }

    private static List<String> createResults(int userSize) {
        String inputResults = InputView.inputResults();
        List<String> results = StringUtil.splitComma(inputResults);
        if (results.size() != userSize) {
            System.out.println("결과와 참여자의 수는 같아야합니다");
            return createResults(userSize);
        }
        return results;
    }

    private static Ladder createLadder(int userSize) {
        try {
            int height = InputView.inputLadderHeight();
            return new Ladder(height, userSize);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return createLadder(userSize);
        }
    }

    private static void printResult(LadderGameResult ladderResult) {
        while (true) {
            String name = InputView.inputName();
            if (name.equals("all")) {
                OutputView.outputAll(ladderResult.getResultMap());
                break;
            }
            OutputView.outputResult(ladderResult.getResultByName(name));
        }
    }

}
