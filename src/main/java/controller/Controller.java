package controller;

import domain.Ladder;
import domain.Ladders;
import domain.RandomGenerator;
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

    public void run(){
        List<String> usersName = settingUsers();
        Ladders ladders = settingLadders();
        ladders.make(usersName.size()-1);
        outputView.printUsers(usersName);
        for (Ladder ladder : ladders.getLadders()) {
            outputView.printLadder(ladder);
        }
    }

    public List<String> settingUsers() {
        try {
            return inputView.inputUsername();
        } catch (IllegalArgumentException e) {
            return settingUsers();
        }
    }

    public Ladders settingLadders() {
        try {
            int height = inputView.inputLadderHeight();
            return new Ladders(height, new RandomGenerator());
        } catch (IllegalArgumentException e) {
            return settingLadders();
        }
    }
}
