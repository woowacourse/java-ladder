package controller;

import domain.Ladder;
import domain.RandomLinkGenerator;
import domain.Results;
import domain.Users;
import view.InputView;
import view.OutputView;

public class LadderController {

    private Users users;
    private Ladder ladder;
    private Results results;

    public void run() {
        generateUsers();
        generateResults();
        generateLadder();
        printResult();
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

    private void printResult() {
        OutputView.printResultMessage();
        OutputView.printUserNames(users.getUsersName());
        OutputView.printLadder(ladder.getLadder());
        OutputView.printResultNames(results.getResultsName());
    }
}
