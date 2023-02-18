package controller;

import domain.Height;
import domain.Ladder;
import domain.User;
import domain.Users;
import java.util.stream.Collectors;
import view.InputView;
import view.OutputView;

import java.util.List;

public class Controller {

    private final Ladder ladder;

    public Controller(final Ladder ladder) {
        this.ladder = ladder;
    }

    public void run() {
        Users users = getUsers();
        Height height = getHeight();

        createLadder(users, height);

        OutputView.printUserNames(users);
        OutputView.printLadder(ladder);
    }

    private Users getUsers() {
        try {
            List<String> userNames = InputView.readUserNames();
            List<User> users = userNames.stream()
                    .map(User::new)
                    .collect(Collectors.toList());
            return new Users(users);
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e);
            return getUsers();
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

    private void createLadder(Users users, Height height) {
        try {
            int userCount = users.getSize();
            ladder.create(height.getHeight(), userCount);
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e);
            createLadder(users, height);
        }
    }
}
