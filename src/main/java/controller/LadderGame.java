package controller;

import domain.Ladder;
import domain.Users;
import view.InputView;
import view.ResultView;

import java.util.List;

public class LadderGame {
    public void run() {
        List<String> userNames = InputView.inputUserNames();
        Users users = new Users(userNames);

        int height = InputView.inputHeight();
        Ladder ladder = new Ladder(height, users.getPersonCount());

        ResultView.printResultMessage();
        ResultView.printNames(users);
        ResultView.printResult(ladder);
    }
}
