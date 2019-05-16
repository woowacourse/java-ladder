package ladderGame.controller;

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

        LadderGame ladderGame = createLadderGame(users.size());
        ladderGame.startLadderGame(users);

        OutputView.printLadderUI(users, ladderGame,ladderGame, results);

        LadderGameResult ladderResult = new LadderGameResult(results, users);
        printResult(ladderResult);
    }

    private static void printResult(LadderGameResult ladderResult) {
        while (true) {
            String name = InputView.inputName();
            OutputView.outputResult(ladderResult.getResultByName(name));
            if (name.equals("all")) {
                OutputView.outputAll(ladderResult.getResultMap());
                break;
            }
        }
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
            System.out.println("결과와 참여자의 수는 같아야 함");
            return createResults(userSize);
        }
        return results;
    }

    private static LadderGame createLadderGame(int userSize) {
        try {
            int height = InputView.inputLadderHeight();
            return new LadderGame(height, userSize);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return createLadderGame(userSize);
        }

    }
}
