package laddergame.controller;

import java.util.Map;
import java.util.function.Supplier;
import laddergame.domain.GameResult;
import laddergame.domain.Results;
import laddergame.domain.Height;
import laddergame.domain.LadderImpl;
import laddergame.domain.Name;
import laddergame.domain.User;
import laddergame.domain.Users;
import java.util.List;
import java.util.stream.Collectors;
import laddergame.domain.dto.ResultsDto;
import laddergame.domain.dto.UsersNameDto;
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
        Results results = repeat(() -> setUpGameResults(users.count()));
        Height ladderHeight = repeat(this::setUpLadderHeight);
        LadderImpl ladder = new LadderImpl(ladderHeight, users.count(), new RandomLineMaker());
        outputView.printLadderResult(ladder, new UsersNameDto(users.getUsers()), new ResultsDto(results.getResults()));
        LadderGame ladderGame = new LadderGame(ladder, users, results);

        Map<String, String> gameResultByUser = ladderGame.play();

        printGameResult(users, gameResultByUser);
    }

    private <T> T repeat(Supplier<T> supplier) {
        try {
            return supplier.get();
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e);
            return repeat(supplier);
        }
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

    private Results setUpGameResults(int userCount) {
        return new Results(generateGameResults(getGameResults()), userCount);
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

}
