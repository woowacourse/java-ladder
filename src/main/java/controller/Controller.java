package controller;

import domain.Height;
import domain.Ladder;
import domain.User;
import domain.Users;
import java.util.List;
import java.util.stream.Collectors;
import utils.LadderRowGenerator;
import view.InputView;
import view.OutputView;

public class Controller {

    private final LadderRowGenerator ladderRowGenerator;

    public Controller(final LadderRowGenerator ladderRowGenerator) {
        this.ladderRowGenerator = ladderRowGenerator;
    }

    public void run() {
        Users users = getUsers();
        Height height = getHeight();

        Ladder ladder = createLadder(users, height);

        OutputView.printResult(users, ladder);
    }

    private Users getUsers() {
        try {
            List<String> userNames = InputView.readUserNames();
            List<User> users = userNames.stream()
                    .map(User::new)
                    .collect(Collectors.toList());
            return new Users(users);
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e);
            return getUsers();
        }
    }

    private Height getHeight() {
        try {
            int height = InputView.readLadderHeight();
            return new Height(height);
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e);
            return getHeight();
        }
    }

    private Ladder createLadder(Users users, Height height) {
        return new Ladder(users.getSize(), height.getHeight(), ladderRowGenerator);
    }
}
