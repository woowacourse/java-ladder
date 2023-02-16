package controller;

import domain.Ladder;
import domain.Users;
import view.InputView;
import view.OutputView;

public class LadderController {
    private Users users;
    private Ladder ladder;

    public void run() {
        generateUsers();
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
            ladder = new Ladder(InputView.readLadderHeight(), users.size());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            generateLadder();
        }
    }

    private void printResult() {
        OutputView.printResultMessage();
        OutputView.printUserNames(users.getUsersName());
        OutputView.printResult(ladder.getLines());
    }
}
