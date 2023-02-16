package controller;

import domain.Ladder;
import domain.Users;
import view.InputView;
import view.OutputView;

public class LadderController {
    private Users users;
    private Ladder ladder;

    public void run() {
        initUsers();
        initLadder();
        printResult();
    }

    private void initUsers() {
        try {
            users = new Users(InputView.readUserNames());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            initUsers();
        }
    }

    private void initLadder() {
        try {
            ladder = new Ladder(InputView.readLadderHeight(), users.size());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            initLadder();
        }
    }

    private void printResult() {
        OutputView.printResultMessage();
        OutputView.printUserNames(users.getUsersName());
        OutputView.printResult(ladder.getLadder());
    }
}
