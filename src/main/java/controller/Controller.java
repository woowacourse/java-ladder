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

    public void run(){
        Users usersName = settingUsers();
        Ladders ladders = settingLadders();
        ladders.make(usersName.getCount()-1);
        outputView.printUsers(usersName);
        for (Ladder ladder : ladders.getLadders()) { //스트림
            outputView.printLadder(ladder);
        }
    }

    public Users settingUsers() {
        try {
            List<String> userNames = inputView.inputUsername();
            List<User> users = userNames.stream()
                    .map(User::new)
                    .collect(Collectors.toList());
            return new Users(users);
        } catch (IllegalArgumentException e) {
            return settingUsers();
        }
    }

    public Ladders settingLadders() {
        try {
            int height = inputView.inputLadderHeight();
            return new Ladders(height, new LadderGenerator());
        } catch (IllegalArgumentException e) {
            return settingLadders();
        }
    }
}
