package controller;

import domain.*;
import dto.LadderDTO;
import dto.LineDTO;
import view.InputView;
import view.OutputView;
import view.ResultView;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Controller {

    private static final String ALL_USER_RESULT = "all";
    private static final String WRONG_RESULT_INPUT_MESSAGE = "존재하지 않는 유저입니다.";

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
        List<String> inputResult = settingResult(users.getCount());
        Height height = settingHeight();
        LadderGame ladderGame = new LadderGame(height, users, new RandomLadderGenerator());
        showLadder(users, ladderGame.getLadderDTO(), inputResult);

        final Result result = ladderGame.play(inputResult);
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

    private void showLadder(final Users users, final LadderDTO ladderDTO, final List<String> inputResult) {
        outputView.printUsers(users.getUsersDTO());
        for (LineDTO lineDTO : ladderDTO.getLadderDTO()) {
            outputView.printLadder(lineDTO);
        }
        outputView.printResult(inputResult);
    }

    private void showResult(final Users users, final Result result) {
        try {
            final String input = readResultInput(users);
            final Map<String, String> gameResult = result.getResult(input);
            resultView.printResult(gameResult);
            if (isPrintAllResult(users, gameResult)) return;
            showResult(users, result);
        } catch (IllegalArgumentException e) {
            resultView.printNonExistUser();
            showResult(users, result);
        }
    }

    private String readResultInput(final Users users) {
        final String input = inputView.inputWantToKnowUser();
        if (!users.contain(input) && !input.equals(ALL_USER_RESULT)) {
            throw new IllegalArgumentException(WRONG_RESULT_INPUT_MESSAGE);
        }
        return input;
    }

    private boolean isPrintAllResult(final Users users, final Map<String, String> gameResult) {
        if (users.getCount() == gameResult.size()) {
            resultView.printGameExitMessage();
            return true;
        }
        return false;
    }
}
