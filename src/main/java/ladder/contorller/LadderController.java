package ladder.contorller;

import java.util.List;
import ladder.domain.game.GameExecutor;
import ladder.domain.GameResource;
import ladder.domain.GameResult;
import ladder.domain.LadderGame;
import ladder.domain.ladder.Ladder;
import ladder.domain.ladder.LadderGenerator;
import ladder.domain.line.RandomLineGenerator;
import ladder.domain.prize.Prize;
import ladder.domain.prize.Prizes;
import ladder.domain.user.User;
import ladder.domain.user.Users;
import ladder.view.InputView;
import ladder.view.OutputView;

public class LadderController {

    private static final String ALL_RESULT = "all";

    private final InputView inputView;
    private final OutputView outputView;
    private LadderGame ladderGame;

    public LadderController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
        initializeGame();
    }

    public void run() {
        registerResource();
        ladderGame.startGame();
        showLadder();
        showGameResult();

        inputView.closeScanner();
    }

    private void initializeGame() {
        ladderGame = new LadderGame(new GameResource(), new GameExecutor(), new GameResult());
    }

    private void registerResource() {
        Users users = createUsers();
        Prizes prizes = createPrizes();
        int numberOfUsers = users.getSize();
        Ladder ladder = createLadder(numberOfUsers);

        ladderGame.registerResource(users, prizes, ladder);
    }

    private void showLadder() {
        GameResource gameResource = ladderGame.getGameResource();
        outputView.printLadderGame(gameResource);
    }

    private void showGameResult() {
        String target = inputView.readGameResultForUser();

        if (target.equals(ALL_RESULT)) {
            outputView.printAllResult(ladderGame.getGameResult());
        }

        if (!target.equals(ALL_RESULT)) {
            User targetUser = searchTargetUser(target);
            Prize prize = searchUserResult(targetUser);
            outputView.printUserResult(prize);
        }
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

    private Prizes createPrizes() {
        try {
            List<String> prizeNames = inputView.readPrizeNames();
            List<Prize> prizes = prizeNames.stream()
                    .map(Prize::new)
                    .toList();

            return new Prizes(prizes);
        } catch (IllegalArgumentException e) {
            outputView.printError(e.getMessage());
            return createPrizes();
        }
    }

    private Ladder createLadder(int ladderWidth) {
        try {
            int ladderHeight = inputView.readLadderHeight();
            LadderGenerator ladderGenerator = new LadderGenerator(new RandomLineGenerator());
            return ladderGenerator.generate(ladderHeight, ladderWidth);

        } catch (IllegalArgumentException e) {
            outputView.printError(e.getMessage());
            return createLadder(ladderWidth);
        }
    }

    private User searchTargetUser(String target) {
        GameResource gameResource = ladderGame.getGameResource();
        Users users = gameResource.getUsers();

        return users.getUsers().stream()
                .filter(user -> user.getUserName().equals(target))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("[ERROR] 해당 사용자를 찾을 수 없습니다."));
    }

    private Prize searchUserResult(User targetUser) {
        GameResult gameResult = ladderGame.getGameResult();
        return gameResult.getUserResult(targetUser);
    }
}
