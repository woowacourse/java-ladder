package controller;

import domain.Height;
import domain.Ladder;
import domain.Name;
import domain.User;
import domain.Users;
import java.util.List;
import java.util.stream.Collectors;
import view.InputView;
import view.OutputView;

public class LadderGameController {

    private final InputView inputView;
    private final OutputView outputView;

    public LadderGameController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        List<String> userNames = getUserNames();
        Users users = new Users(generateUsers(userNames));
        Height ladderHeight = new Height(getLadderHeight());
        Ladder ladder = new Ladder(ladderHeight, userNames.size());
        printResult(ladder, users);
    }

    private List<String> getUserNames() {
        outputView.printEnterUserNotice();
        return inputView.inputUserNames();
    }

    private int getLadderHeight() {
        outputView.printEnterHeightNotice();
        return inputView.inputHeight();
    }

    private List<User> generateUsers(List<String> userNames) {
        return userNames.stream()
                .map(Name::new)
                .map(User::new)
                .collect(Collectors.toUnmodifiableList());
    }

    private void printResult(Ladder ladder, Users users) {
        outputView.printGameResult(ladder, users);
    }
}
