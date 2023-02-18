package controller;

import domain.*;
import view.InputView;
import view.OutputView;

import java.util.List;
import java.util.stream.Collectors;

public class Controller {
    private final InputView inputView;
    private final OutputView outputView;

    public Controller(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        Users users = settingUsers();
        Width width = new Width(users.getCount() - 1);
        Ladders ladders = settingLadders(width);
        ladders.make(LadderGenerator.getInstance());
        outputView.printUsers(users);
        for (Ladder ladder : ladders.getLadders()) {
            outputView.printLadder(ladder);
        }
    }

    private Users settingUsers() {
        try {
            List<String> userNames = inputView.inputUsername();
            return new Users(makeUsers(userNames));
        } catch (IllegalArgumentException e) {
            outputView.printExceptionMessage(e.getMessage());
            return settingUsers();
        }
    }

    private List<User> makeUsers(List<String> userNames) {
        return userNames.stream()
                .map(User::new)
                .collect(Collectors.toList());
    }

    private Ladders settingLadders(Width width) {
        try {
            int height = inputView.inputLadderHeight();
            return new Ladders(new Height(height), width);
        } catch (IllegalArgumentException e) {
            outputView.printExceptionMessage(e.getMessage());
            return settingLadders(width);
        }
    }
}
