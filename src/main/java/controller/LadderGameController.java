package controller;

import domain.*;
import view.InputView;
import view.OutputView;

import java.util.ArrayList;
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
            String name = InputView.readTargetUserName();
            printResultWhenTargetIsNotAll(name);
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
        OutputView.printLadder(formatPrimitiveLadder());
        OutputView.printResultNames(results.getResultNames());
    }

    private List<List<Boolean>> formatPrimitiveLadder() {
        List<List<Boolean>> primitiveLadder = new ArrayList<>();
        List<Line> lines = ladder.getLadder();
        for (Line line : lines) {
            formatPrimitiveLine(primitiveLadder, line);
        }
        return primitiveLadder;
    }

    private void formatPrimitiveLine(final List<List<Boolean>> primitiveLadder, final Line line) {
        List<Boolean> primitiveLine = new ArrayList<>();
        for (Link link : line.getLinks()) {
            primitiveLine.add(link.isLink());
        }
        primitiveLadder.add(primitiveLine);
    }

    private void calculateLadderGameResult() {
        CalculateLadderGameResult calculator = new CalculateLadderGameResult();
        lastUserPositions = calculator.passLadder(ladder.getLadder(), users.getUserNames());
    }

    private void printResultWhenTargetIsNotAll(String name) {
        while (!name.equals("all")) {
            printTargetUserResult(name);
            name = InputView.readTargetUserName();
        }
    }

    private void printTargetUserResult(final String userName) {
        users.isExist(userName);
        int index = lastUserPositions.indexOf(userName);
        String result = results.getResultNames().get(index);
        OutputView.printUserResult(result);
    }

    private void printAllResult() {
        OutputView.printAllResult(lastUserPositions, results.getResultNames());
    }
}
