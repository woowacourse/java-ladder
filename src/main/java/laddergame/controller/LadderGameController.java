package laddergame.controller;

import java.util.Map;
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
import laddergame.view.InputView;
import laddergame.view.OutputView;

public class LadderGameController {

    private final InputView inputView;
    private final OutputView outputView;

    public LadderGameController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        Users users = setUpUsers();
        GameResults gameResults = setUpGameResults(users.count());
        Height ladderHeight = setUpLadderHeight();
        Ladder ladder = new Ladder(ladderHeight, users.count());
        outputView.printLadderResult(ladder, users, gameResults);
        LadderGame ladderGame = new LadderGame(ladder, users, gameResults);

        Map<String, String> gameResultByUser = ladderGame.play();

        printGameResult(users, gameResultByUser);
    }

    private Users setUpUsers() {
        try {
            return new Users(generateUsers(getUserNames()));
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e);
            return setUpUsers();
        }
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
        try {
            return new GameResults(generateGameResults(getGameResults()), userCount);
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e);
            return setUpGameResults(userCount);
        }
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
        try {
            return new Height(getLadderHeight());
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e);
            return setUpLadderHeight();
        }
    }

    private int getLadderHeight() {
        outputView.printEnterHeightNotice();
        return inputView.inputHeight();
    }

    private void printGameResult(Users users, Map<String, String> gameResultByUser) {
        String userToCheckResult;
        do {
            userToCheckResult = getUserToCheckResult(users);
            printResultOfUser(userToCheckResult, gameResultByUser);
        } while (!userToCheckResult.equals("all"));
    }

    private String getUserToCheckResult(Users users) {
        try {
            outputView.printEnterUserToCheckResultNotice();
            String userToCheckResult = inputView.inputUserToCheckResult();
            users.validateResultCheckCommand(userToCheckResult);
            return userToCheckResult;
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e);
            return getUserToCheckResult(users);
        }
    }

    private void printResultOfUser(String userToCheckResult, Map<String, String> gameResultByUser) {
        if (userToCheckResult.equals("all")) {
            outputView.printResultOfAllUser(gameResultByUser);
            return;
        }
        outputView.printResultOfOneUser(gameResultByUser.get(userToCheckResult));
    }

}
