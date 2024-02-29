package ladder.contorller;

import java.util.List;
import ladder.domain.ladder.Ladder;
import ladder.domain.line.Line;
import ladder.domain.position.Positions;
import ladder.domain.prize.Prize;
import ladder.domain.prize.Prizes;
import ladder.domain.result.Result;
import ladder.domain.user.User;
import ladder.domain.user.Users;
import ladder.view.InputView;
import ladder.view.OutputView;

import static java.util.stream.Collectors.*;

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
        Prizes prizes = createPrizes(numberOfUsers);
        Ladder ladder = createLadder(numberOfUsers);
        Positions positions = createPositions(numberOfUsers, ladder);
        Result result = createResult(users, prizes, positions);

        outputView.printLadderResult(users, ladder, prizes);

    }

    private Users createUsers() {
        try {
            List<String> userNames = inputView.readUserNames();
            return userNames.stream()
                    .map(User::new)
                    .collect(collectingAndThen(toList(), Users::new));
        } catch (IllegalArgumentException e) {
            outputView.printError(e.getMessage());
            return createUsers();
        }
    }

    private Prizes createPrizes(int userSize) {
        try {
            List<String> prizeNames = inputView.readPrizeNames();
            return prizeNames.stream()
                    .map(Prize::new)
                    .collect(collectingAndThen(toList(), list -> new Prizes(list, userSize)));
        } catch (IllegalArgumentException e) {
            outputView.printError(e.getMessage());
            return createPrizes(userSize);
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

    private Positions createPositions(int width, Ladder ladder) {
        Positions defaultPositions = new Positions(width);
        List<Line> lines = ladder.getLines();
        Positions nowPositions = defaultPositions;
        for (Line line : lines) {
            nowPositions = nowPositions.calcPosition(line);
        }
        return nowPositions;
    }

    private Result createResult(Users users, Prizes prizes, Positions positions) {
        return new Result(users.getUsersNames(), prizes.getPrizesNames(), positions.getPositions());
    }
}
