package controller;

import domain.*;
import dto.LadderDTO;
import dto.LineDTO;
import view.InputView;
import view.OutputView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Controller {

    private static final String ALL_USER_RESULT = "all";
    private static final String WRONG_RESULT_INPUT_MESSAGE = "존재하지 않는 유저입니다.";

    private final InputView inputView;
    private final OutputView outputView;

    public Controller(final InputView inputView, final OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        Users users = settingUsers();
        WinningResults winningResults = settingResult(users.getCount());
        Height height = settingHeight();
        LadderGame ladderGame = new LadderGame(height, users, new RandomLadderGenerator());
        showLadder(users, ladderGame.getLadderDTO(), winningResults);

        final Result result = ladderGame.play(winningResults);
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

    private WinningResults settingResult(final int userCount) {
        try {
            final List<String> inputResults = inputView.inputResult(userCount);
            List<WinningResult> winningResults = new ArrayList<>();
            for (String inputResult : inputResults) {
                winningResults.add(new WinningResult(inputResult));
            }
            return new WinningResults(winningResults);
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

    private void showLadder(final Users users, final LadderDTO ladderDTO, final WinningResults winningResults) {
        outputView.printUsers(users.getUsersDTO());
        for (LineDTO lineDTO : ladderDTO.getLadderDTO()) {
            outputView.printLadder(lineDTO);
        }
        outputView.printWinningResult(winningResults.getWinningResults());
    }

    private void showResult(final Users users, final Result result) {
        try {
            final String input = readResultInput(users);
            final Map<String, WinningResult> gameResult = result.getResult(input);
            outputView.printGameResult(gameResult);
            if (input.equals(ALL_USER_RESULT)) {
                return;
            }
            showResult(users, result);
        } catch (IllegalArgumentException e) {
            outputView.printExceptionMessage(e.getMessage());
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
}
