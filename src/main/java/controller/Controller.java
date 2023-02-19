package controller;

import domain.*;
import view.InputView;
import view.OutputView;

import java.util.List;

public class Controller {
    private final InputView inputView;
    private final OutputView outputView;

    public Controller(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        Users users = settingUsers();
        Items items = settingItems(users);
        Ladders ladders = new Ladders(users.getCount(), settingHeight(), new RandomGenerator());

        outputView.printLadderResultBoard(users, items, ladders);
        Result result = new Result(users, items, ladders);

        while (true) {
            String query = inputView.inputWinner();
            if (query.equals("all")) {
                outputView.printUsersResult(result);
            } else {
                outputView.printUserResult(result.getItem(new User(query)));
            }
        }
    }

    private Users settingUsers() {
        try {
            List<User> userNames = inputView.inputUserName();
            return new Users(userNames);
        } catch (IllegalArgumentException e) {
            outputView.printExceptionMessage(e.getMessage());
            return settingUsers();
        }
    }

    private Items settingItems(Users users) {
        try {
            return new Items(inputView.inputItem(), users);
        } catch (IllegalArgumentException e) {
            outputView.printExceptionMessage(e.getMessage());
            return settingItems(users);
        }
    }

    private Height settingHeight() {
        try {
            int height = inputView.inputLadderHeight();
            return new Height(height);
        } catch (IllegalArgumentException e) {
            outputView.printExceptionMessage(e.getMessage());
            return settingHeight();
        }
    }
}
