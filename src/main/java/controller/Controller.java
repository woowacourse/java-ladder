package controller;

import java.util.List;

import domain.Ladder;
import domain.LadderRow;
import domain.User;
import domain.Users;
import utils.LadderRowGenerator;
import utils.StringParser;
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
        List<String> userNames = users.getUserNames();
        OutputView.printUserNames(userNames);
    }

    private void printLadder() {
        List<String> ladders = StringParser.parseLadderToString(ladder);
        OutputView.printLadder(ladders);
    }

    private void createLadder() {
        int ladderHeight = InputView.readLadderHeight();
        int userCount = users.getSize();
        for (int i = 0; i < ladderHeight; i++) {
            LadderRow line = LadderRowGenerator.generate(userCount);
            ladder.add(line);
        }
    }

    private void createUser() {
        List<String> userNames = InputView.readUserNames();
        for (String userName : userNames) {
            users.add(new User(userName));
        }
    }
}
