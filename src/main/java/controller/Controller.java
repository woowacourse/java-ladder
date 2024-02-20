package controller;

import domain.Ladder;
import domain.User;
import domain.Users;
import view.InputView;
import view.ResultView;

public class Controller {

    public void run() {
        String userName = InputView.inputUserNames();
        Users users = new Users(userName);
        int height = InputView.inputHeight();
        Ladder ladder = new Ladder(height, users.gerPersonCount());
        ResultView.printNames(userName.split(","));
        ResultView.printResult(ladder);
    }
}
