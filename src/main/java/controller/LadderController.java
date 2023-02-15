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
        users = new Users(InputView.readUserNames());
    }

    private void generateLadder() {
        ladder = new Ladder(InputView.readLadderHeight(), users.size());
    }

    private void printResult() {
        OutputView.printResultMessage();
        OutputView.printUserNames(users.getUsersName());
        OutputView.printResult(ladder.getLines());
    }
}
