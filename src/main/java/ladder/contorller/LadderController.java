package ladder.contorller;

import java.util.List;
import ladder.domain.ladder.Ladder;
import ladder.domain.user.User;
import ladder.domain.user.Users;
import ladder.view.InputView;
import ladder.view.OutputView;

public class LadderController {

    private final InputView inputView;
    private final OutputView outputView;

    public LadderController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        Users users = createUsers();
        int numberOfUsers = users.getNumberOfUsers();

        Ladder ladder = createLadder(numberOfUsers);

        outputView.printLadderGameResult(users, ladder);
    }

    private Users createUsers() {
        try {
            List<String> userNames = inputView.readUserNames();
            List<User> users = userNames.stream()
                    .map(User::new)
                    .toList();

            return new Users(users);
        } catch (IllegalArgumentException e) {
            outputView.printError(e.getMessage());
            return createUsers();
        }
    }

    private Ladder createLadder(int ladderWidth) {
        try {
            int ladderHeight = inputView.readLadderHeight();

            return new Ladder(ladderHeight, ladderWidth);
        } catch (IllegalArgumentException e) {
            outputView.printError(e.getMessage());
            return createLadder(ladderWidth);
        }
    }
}
