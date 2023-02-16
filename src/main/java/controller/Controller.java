package controller;

import domain.*;
import view.InputView;
import view.OutputView;

import java.util.List;
import java.util.stream.Collectors;

public class Controller {
    private final InputView inputView;
    private final OutputView outputView;
    private final LadderGenerator ladderGenerator;

    public Controller(InputView inputView, OutputView outputView, LadderGenerator ladderGenerator) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.ladderGenerator = ladderGenerator;
    }

    public void run() {
        Users usersName = settingUsers();
        Ladders ladders = settingLadders();
        ladders.make(usersName.getCount() - 1, ladderGenerator);
        outputView.printUsers(usersName);
        for (Ladder ladder : ladders.getLadders()) { //스트림
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

    private Ladders settingLadders() {
        try {
            int height = inputView.inputLadderHeight();
            return new Ladders(new Height(height));
        } catch (IllegalArgumentException e) {
            outputView.printExceptionMessage(e.getMessage());
            return settingLadders();
        }
    }
}
