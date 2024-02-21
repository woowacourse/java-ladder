package controller;

import common.exception.message.ExceptionMessage;
import common.exception.model.IOException;
import common.exception.model.ValidationException;
import domain.Ladder;
import domain.LadderHeight;
import domain.PlayerName;
import domain.PlayerNames;
import view.InputView;
import view.OutputView;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

public class LadderGame {
    private final InputView inputView;
    private final OutputView outputView;

    public LadderGame(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void start() {
        PlayerNames playerNames = readPlayerNames();
        LadderHeight ladderHeight = readLadderHeight();

        Ladder ladder = createLadder(playerNames, ladderHeight);
        outputView.printResult(playerNames, ladder);
    }

    private Ladder createLadder(PlayerNames playerNames, LadderHeight ladderHeight) {
        int pointCount = calculatePointCount(playerNames);
        return Ladder.of(ladderHeight, pointCount);
    }

    private int calculatePointCount(PlayerNames playerNames) {
        return playerNames.getCount() - 1;
    }

    public PlayerNames readPlayerNames() {
        return retry(() -> createPlayerNames(inputView.readPlayerNames()), 0);
    }

    public PlayerNames createPlayerNames(String playerNamesInput) {
        String[] splitPlayerNames = splitPlayerNames(playerNamesInput);
        List<PlayerName> playerNames = Arrays.stream(splitPlayerNames)
                .map(PlayerName::new)
                .toList();

        return new PlayerNames(playerNames);
    }

    private String[] splitPlayerNames(String playerNamesInput) {
        playerNamesInput = playerNamesInput.replace(InputView.BLANK_SPACE, InputView.BLANK_EMPTY);
        validatePlayerNamesInput(playerNamesInput);

        return playerNamesInput.split(InputView.PLAYER_NAMES_INPUT_DELIMITER);
    }

    private void validatePlayerNamesInput(String playerNamesInput) {
        if (!InputView.PLAYER_NAMES_INPUT_PATTERN.matcher(playerNamesInput).matches()) {
            throw new ValidationException(ExceptionMessage.PLAYER_NAMES_INPUT_FORMAT);
        }
    }

    public LadderHeight readLadderHeight() {
        return retry(() -> new LadderHeight(inputView.readLadderHeight()), 0);
    }

    public <R> R retry(final Supplier<R> supplier, final int retryCount) {
        if (retryCount == InputView.READ_LIMIT) {
            throw new IOException(ExceptionMessage.READ_LIMIT_OVER);
        }
        try {
            return supplier.get();
        } catch (Exception exception) {
            outputView.printErrorMessage(exception);
            return retry(supplier, retryCount + 1);
        }
    }
}
