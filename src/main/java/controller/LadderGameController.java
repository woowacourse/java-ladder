package controller;

import domain.*;
import view.InputView;
import view.OutputView;

import java.util.List;

public class LadderGameController {

    private Users users;
    private Ladder ladder;
    private Results results;
    private List<String> lastUserPositions;

    public void makeLadderGame() {
        generateUsers();
        generateResults();
        generateLadder();
        printLadder();
        calculateLadderGameResult();
    }

    public void printResult() {
        try {
            String name = InputView.readWantUserName();
            printResultWhenNotWantAll(name);
            printAllResult();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            printResult();
        }
    }

    private void generateUsers() {
        try {
            users = new Users(InputView.readUserNames());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            generateUsers();
        }
    }

    private void generateLadder() {
        try {
            ladder = new Ladder(InputView.readLadderHeight(), users.size(), new RandomLinkGenerator());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            generateLadder();
        }
    }

    private void generateResults() {
        try {
            results = new Results(InputView.readResultNames(), users.size());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            generateResults();
        }
    }

    private void printLadder() {
        OutputView.printResultMessage();
        OutputView.printUserNames(users.getUserNames());
        OutputView.printLadder(ladder.getLadder());
        OutputView.printResultNames(results.getResultNames());
    }

    private void calculateLadderGameResult() {
        CalculateLadderGameResult calculator = new CalculateLadderGameResult();
        lastUserPositions = calculator.passLadder(ladder.getLadder(), users.getUserNames());
    }

    private void printResultWhenNotWantAll(String name) {
        while(!name.equals("all")) {
            printUserResult(name);
            name = InputView.readWantUserName();
        }
    }

    private void printUserResult(final String userName) {
        users.isExist(userName);
        int index = lastUserPositions.indexOf(userName);
        String result = results.getResultNames().get(index);
        OutputView.printUserResult(result);
    }

    private void printAllResult() {
        OutputView.printAllResult(lastUserPositions, results.getResultNames());
    }
}
