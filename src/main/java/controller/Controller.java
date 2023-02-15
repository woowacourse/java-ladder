package controller;

import java.util.List;

import domain.Ladder;
import domain.LadderRow;
import domain.User;
import domain.Users;
import utils.LadderRowGenerator;
import utils.StringParser;
import utils.constants.Validator;
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

    private void createUser() {
        try {
            List<String> userNames = InputView.readUserNames();
            userNames.forEach(userName -> users.add(new User(userName)));
        } catch (IllegalArgumentException exception) {
            OutputView.printErrorMessage(exception);
            createUser();
        }
    }

    private void createLadder() {
        try {
            int ladderHeight = InputView.readLadderHeight();
            int userCount = users.getSize();
            addLadder(ladderHeight, userCount);
        } catch (IllegalArgumentException exception) {
            OutputView.printErrorMessage(exception);
            createLadder();
        }
    }

    private void addLadder(int ladderHeight, int userCount) {
        Validator.validateLadderHeight(ladderHeight);
        for (int i = 0; i < ladderHeight; i++) {
            LadderRow line = LadderRowGenerator.generate(userCount);
            ladder.add(line);
        }
    }

    private void printUsers() {
        List<String> userNames = users.getUserNames();
        OutputView.printUserNames(userNames);
    }

    private void printLadder() {
        List<String> ladders = StringParser.parseLadderToString(ladder);
        OutputView.printLadder(ladders);
    }
}
