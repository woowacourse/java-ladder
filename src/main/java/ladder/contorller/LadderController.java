package ladder.contorller;

import java.util.ArrayList;
import java.util.List;
import ladder.domain.resource.direction.DirectionGeneratorImpl;
import ladder.domain.resource.ladder.Ladder;
import ladder.domain.resource.line.Line;
import ladder.domain.resource.line.LineGenerator;
import ladder.domain.resource.user.User;
import ladder.domain.resource.user.Users;
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
        inputView.closeScanner();

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
            List<Line> lines = createLines(ladderHeight, ladderWidth);

            return new Ladder(lines);
        } catch (IllegalArgumentException e) {
            outputView.printError(e.getMessage());
            return createLadder(ladderWidth);
        }
    }

    private List<Line> createLines(int ladderHeight, int ladderWidth) {
        List<Line> lines = new ArrayList<>();
        LineGenerator lineGenerator = new LineGenerator(new DirectionGeneratorImpl());

        for (int i = 0; i < ladderHeight; i++) {
            lines.add(lineGenerator.generate(ladderWidth));
        }

        return lines;
    }
}
