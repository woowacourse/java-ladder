package controller;

import domain.*;
import view.InputView;
import view.OutputView;
import view.ResultView;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Controller {

    private static final String ALL_USER_RESULT = "all";

    private final InputView inputView;
    private final OutputView outputView;
    private final ResultView resultView;

    public Controller(final InputView inputView, final OutputView outputView, final ResultView resultView) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.resultView = resultView;
    }

    public void run() {
        Users users = settingUsers();
        Width width = new Width(users.getCount() - 1);
        List<String> inputResult = settingResult(users.getCount());
        Height height = settingHeight();
        Ladder ladder = new Ladder(height, width, new RandomLadderGenerator());

        showLadder(users, ladder, inputResult);

        Result result = playLadderGame(users, ladder, inputResult);
        showResult(users, result);
    }

    private Users settingUsers() {
        try {
            List<String> userNames = inputView.inputUsername();
            return new Users(makeUsers(userNames));
        } catch (IllegalArgumentException e) {
            outputView.printExceptionMessage(e.getMessage());
            return settingUsers();
        }
    }

    private List<User> makeUsers(final List<String> userNames) {
        return userNames.stream()
                .map(User::new)
                .collect(Collectors.toList());
    }

    private List<String> settingResult(final int userCount) {
        try {
            return inputView.inputResult(userCount);
        } catch (IllegalArgumentException e) {
            outputView.printExceptionMessage(e.getMessage());
            return settingResult(userCount);
        }
    }

    private Height settingHeight() {
        try {
            return new Height(inputView.inputLadderHeight());
        } catch (IllegalArgumentException e) {
            outputView.printExceptionMessage(e.getMessage());
            return settingHeight();
        }
    }

    private void showLadder(final Users users, final Ladder ladder, final List<String> inputResult) {
        outputView.printUsers(users.getUsersDTO());
        for (Line line : ladder.getLadder()) {
            outputView.printLadder(line.getLineDTO());
        }
        outputView.printResult(inputResult);
    }

    private Result playLadderGame(final Users users, final Ladder ladder, List<String> inputResult) {
        Map<String, Integer> ladderGameResult = ladder.play(users);
        return new Result(inputResult, ladderGameResult);
    }

    private void showResult(final Users users, final Result result) {
        try {
            checkResult(users, result);
        } catch (IllegalArgumentException e) {
            resultView.printNonExistUser();
            showResult(users, result);
        }
    }

    private void checkResult(final Users users, final Result result) {
        String inputResultWord = inputView.inputWantToKnowUser();
        validateIsExistUser(inputResultWord, users);
        final Map<String, String> gameResult = result.getResult(inputResultWord);
        resultView.printResult(gameResult);
        if (users.getCount() == gameResult.size()) {
            resultView.printGameExitMessage();
            return;
        }
        checkResult(users, result);
    }

    private void validateIsExistUser(final String userName, final Users users) {
        if (!users.contain(userName) && !userName.equals(ALL_USER_RESULT)) {
            throw new IllegalArgumentException("존재하지 않는 유저입니다.");
        }
    }
}
