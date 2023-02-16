package controller;

import domain.*;
import view.InputView;
import view.OutputView;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Controller {
    private final InputView inputView;
    private final OutputView outputView;
    private final LadderGenerator ladderGenerator;

    public Controller(InputView inputView, OutputView outputView, LadderGenerator ladderGenerator) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.ladderGenerator = ladderGenerator;
    }

    public void run(){
        Users usersName = settingUsers();
        int height = settingLadders();
        List<Ladder> ladderResult = IntStream.rangeClosed(0, height-1)
                .mapToObj(i -> new Ladder(getLadder(usersName)))
                .collect(Collectors.toList());

        Ladders ladders = new Ladders(ladderResult);
        outputView.printUsers(usersName);
        ladders.getLadders().forEach(outputView::printLadder);
    }

    private List<Bridge> getLadder(Users usersName) {
        return ladderGenerator.generateLadder(usersName.getCount() - 1);
    }

    public Users settingUsers() {
        try {
            List<String> userNames = inputView.inputUsername();
            List<User> users = userNames.stream()
                    .map(User::new)
                    .collect(Collectors.toList());
            return new Users(users);
        } catch (IllegalArgumentException e) {
            outputView.printExceptionMessage(e.getMessage());
            return settingUsers();
        }
    }

    public int settingLadders() {
        try {
            return inputView.inputLadderHeight();
        } catch (IllegalArgumentException e) {
            outputView.printExceptionMessage(e.getMessage());
            return settingLadders();
        }
    }
}
