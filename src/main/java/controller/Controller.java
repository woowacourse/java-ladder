package controller;

import domain.Height;
import domain.Ladder;
import domain.User;
import domain.Users;
import utils.Validator;
import view.InputView;
import view.OutputView;

import java.util.List;

public class Controller {

    private final Ladder ladder;
    private final Users users;

    public Controller(final Ladder ladder, final Users users) {
        this.ladder = ladder;
        this.users = users;
    }

    public void run() {
        createUser();
        Height height = getHeight();
        createLadder(height);
        printUsers();
        printLadder();
    }

    private void createUser() {
        try {
            List<String> userNames = InputView.readUserNames();
            Validator.validateDuplication(userNames);
            userNames.forEach(userName -> users.add(new User(userName)));
        } catch (IllegalArgumentException exception) {
            OutputView.printErrorMessage(exception);
            createUser();
        }
    }

    private Height getHeight() {
        try {
            int height = InputView.readLadderHeight();
            return new Height(height);
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e);
            return getHeight();
        }
    }

    private void createLadder(Height height) {
        try {
            int userCount = users.getSize();
            ladder.create(height.getHeight(), userCount);
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e);
            createLadder(height);
        }
    }

    private void printUsers() {
        List<String> userNames = users.getUserNames();
        OutputView.printUserNames(userNames);
    }

    private void printLadder() {
        List<String> ladderMap = ladder.parseLadderToString();
        OutputView.printLadder(ladderMap);
    }
}
