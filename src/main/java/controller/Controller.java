package controller;

import domain.Ladder;
import domain.Users;
import view.InputView;
import view.ResultView;

import java.util.List;

public class Controller {

    public void run() {
        List<String> userNames = InputView.inputUserNames();
        Users users = new Users(userNames);
        int height = InputView.inputHeight();
        Ladder ladder = new Ladder(height, users.gerPersonCount());
        ResultView.printNames(userNames);
        ResultView.printResult(ladder);
    }
}
