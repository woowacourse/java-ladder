package controller;

import domain.*;
import view.InputView;
import view.OutputView;

import java.util.ArrayList;
import java.util.List;

import static exception.ErrorMessage.USER_NAME_NOT_EXISTS_IN_USERS_EXCEPTION;

public class LadderGameController {

    private List<String> firstUserPositions;
    private List<String> lastUserPositions;
    private List<String> resultPositions;

    public void run() {
        Users users = generateUsers();
        Results results = generateResults(users);
        Ladder ladder = generateLadder(users);
        printLadder(users, results, ladder);

        storeLadderGameResult(users, results, ladder);

        printResult(users);
    }

    private void printResult(Users users) {
        String name = InputView.readTargetUserName();
        while(!"all".equals(name)) {
            printResultWhenTargetIsNotAll(users, name);
            name = InputView.readTargetUserName();
        }
        printAllResult();
    }

    private Users generateUsers() {
        Users users = null;
        try {
            users = new Users(InputView.readUserNames());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            generateUsers();
        }
        return users;
    }

    private Ladder generateLadder(final Users users) {
        Ladder ladder = null;
        try {
            ladder = new Ladder(InputView.readLadderHeight(), users.size(), new RandomBooleanGenerator());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            generateLadder(users);
        }
        return ladder;
    }

    private Results generateResults(final Users users) {
        Results results = null;
        try {
            results = new Results(InputView.readResultNames(), users.size());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            generateResults(users);
        }
        return results;
    }

    private void printLadder(final Users users, final Results results, final Ladder ladder) {
        OutputView.printResultMessage();
        OutputView.printUserNames(users.getUserNames());
        OutputView.printLadder(formatPrimitiveLadder(ladder));
        OutputView.printResultNames(results.getResultNames());
    }

    private List<List<Boolean>> formatPrimitiveLadder(final Ladder ladder) {
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

    private void storeLadderGameResult(final Users users, final Results results, final Ladder ladder) {
        firstUserPositions = users.getUserNames();
        lastUserPositions = calculateLadderGameResult(users, ladder);
        resultPositions = results.getResultNames();
    }

    private List<String> calculateLadderGameResult(final Users users, final Ladder ladder) {
        CalculateLadderGameResult calculator = new CalculateLadderGameResult();
        return calculator.passLadder(ladder.getLadder(), users.getUserNames());
    }

    private void printResultWhenTargetIsNotAll(final Users users, final String name) {
        try {
            printTargetUserResult(users, name);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private void printTargetUserResult(final Users users, final String name) {
        if (!users.isExist(name)) {
            throw new IllegalArgumentException(USER_NAME_NOT_EXISTS_IN_USERS_EXCEPTION.getMessage());
        }
        int index = lastUserPositions.indexOf(name);
        String result = resultPositions.get(index);
        OutputView.printUserResult(result);
    }

    private void printAllResult() {
        List<String> swapResultPositions = swapResultPositionsByFirstUserPosition();
        OutputView.printAllResult(firstUserPositions, swapResultPositions);
    }

    // 초기 참여자 순서대로 결과를 재배열
    private List<String> swapResultPositionsByFirstUserPosition() {
        List<String> swapResultPositions = new ArrayList<>();
        for (String userName : firstUserPositions) {
            int firstUserIndex = lastUserPositions.indexOf(userName);
            String firstUserResultName = resultPositions.get(firstUserIndex);
            swapResultPositions.add(firstUserResultName);
        }
        return swapResultPositions;
    }
}
