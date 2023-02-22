package laddergame.controller;

import java.util.Map;
import java.util.function.Supplier;
import laddergame.domain.GameResult;
import laddergame.domain.GameResults;
import laddergame.domain.Height;
import laddergame.domain.Ladder;
import laddergame.domain.Name;
import laddergame.domain.User;
import laddergame.domain.Users;
import java.util.List;
import java.util.stream.Collectors;
import laddergame.service.LadderGame;
import laddergame.utils.RandomLineMaker;
import laddergame.view.InputView;
import laddergame.view.OutputView;

public class LadderGameController {

    private static final String ALL = "all";

    private final InputView inputView;
    private final OutputView outputView;

    public LadderGameController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        Users users = repeat(this::setUpUsers);
        GameResults gameResults = repeat(() -> setUpGameResults(users.count()));
        Height ladderHeight = repeat(this::setUpLadderHeight);
        Ladder ladder = new Ladder(ladderHeight, users.count(), new RandomLineMaker());
        outputView.printLadderResult(ladder, users, gameResults);
        LadderGame ladderGame = new LadderGame(ladder, users, gameResults);

        Map<String, String> gameResultByUser = ladderGame.play();

        printGameResult(users, gameResultByUser);
    }

    private Users setUpUsers() {
        return new Users(generateUsers(getUserNames()));
    }

    private List<User> generateUsers(List<String> userNames) {
        return userNames.stream()
                .map(username -> new User(new Name(username)))
                .collect(Collectors.toUnmodifiableList());
    }

    private List<String> getUserNames() {
        outputView.printEnterUserNotice();
        return inputView.inputUserNames();
    }

    private GameResults setUpGameResults(int userCount) {
        return new GameResults(generateGameResults(getGameResults()), userCount);
    }

    private List<GameResult> generateGameResults(List<String> results) {
        return results.stream()
                .map(GameResult::new)
                .collect(Collectors.toUnmodifiableList());
    }

    private List<String> getGameResults() {
        outputView.printEnterGameResultsNotice();
        return inputView.inputGameResults();
    }

    private Height setUpLadderHeight() {
        return new Height(getLadderHeight());
    }

    private int getLadderHeight() {
        outputView.printEnterHeightNotice();
        return inputView.inputHeight();
    }

    private void printGameResult(Users users, Map<String, String> gameResultByUser) {
        String userToCheckResult;
        do {
            userToCheckResult = repeat(() -> getUserToCheckResult(users));
            printResultOfUser(userToCheckResult, gameResultByUser);
        } while (!userToCheckResult.equals(ALL));
    }

    private String getUserToCheckResult(Users users) {
        outputView.printEnterUserToCheckResultNotice();
        String userToCheckResult = inputView.inputUserToCheckResult();
        users.validateResultCheckCommand(userToCheckResult);
        return userToCheckResult;
    }

    private void printResultOfUser(String userToCheckResult, Map<String, String> gameResultByUser) {
        if (userToCheckResult.equals(ALL)) {
            outputView.printResultOfAllUser(gameResultByUser);
            return;
        }
        outputView.printResultOfOneUser(gameResultByUser.get(userToCheckResult));
    }

    private <T> T repeat(Supplier<T> supplier) {
        try {
            return supplier.get();
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e);
            return repeat(supplier);
        }
    }

}
