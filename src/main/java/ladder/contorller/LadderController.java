package ladder.contorller;

import java.util.ArrayList;
import java.util.List;
import ladder.domain.ladder.Ladder;
import ladder.domain.ladder.Line;
import ladder.domain.ladder.LineGenerator;
import ladder.domain.user.User;
import ladder.domain.user.Users;
import ladder.view.InputView;
import ladder.view.OutputView;

public class LadderController {

    private final InputView inputView;
    private final OutputView outputView;
    private final LineGenerator lineGenerator;

    public LadderController(InputView inputView, OutputView outputView, LineGenerator lineGenerator) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.lineGenerator = lineGenerator;
    }

    public void run() {
        Users users = createUsers();
        int numberOfUsers = users.getNumberOfUsers();

        Ladder ladder = createLadder(numberOfUsers);

        outputView.printLadderGameResult(users, ladder);
    }

    private Users createUsers() {
        List<String> userNames = inputView.readUserNames();
        List<User> users = userNames.stream()
                .map(User::new)
                .toList();

        return new Users(users);
    }

    private Ladder createLadder(int numberOfUsers) {
        List<Line> lines = createLines(numberOfUsers);
        return new Ladder(lines);
    }

    private List<Line> createLines(int numberOfUsers) {
        int ladderHeight = inputView.readLadderHeight();
        List<Line> lines = new ArrayList<>();
        for (int i = 0; i < ladderHeight; i++) {
            lines.add(lineGenerator.generate(numberOfUsers));
        }

        return lines;
    }
}
