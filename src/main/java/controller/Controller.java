package controller;

import java.util.List;

import domain.Ladder;
import domain.Line;
import domain.User;
import domain.Users;
import utils.LineGenerator;
import view.InputView;
import view.OutputView;

public class Controller {
    private final Ladder ladder;
    private final Users users;

    public Controller(Ladder ladder, Users users) {
        this.ladder = ladder;
        this.users = users;
    }

    public void run() {
        createUser();
        createLadder();
        printUsers();
        printLadder();
    }

    private void printUsers() {
        List<String> userNames = users.getUsers();
        OutputView.printUserNames(userNames);
    }

    private void printLadder() {
    }

    private void createLadder() {
        int ladderHeight = InputView.readLadderHeight();
        Line previousLine = LineGenerator.generateFirstLine(ladderHeight);
        ladder.add(previousLine);
        for (int i = 0; i < users.retrieveSize() - 2; i++) {
            Line line = LineGenerator.generate(previousLine);
            ladder.add(line);
            previousLine = line;
        }
    }

    private void createUser() {
        List<String> userNames = InputView.readUserNames();
        for (String userName : userNames) {
            users.add(new User(userName));
        }
    }
}
