package controller;

import common.exception.message.ExceptionMessage;
import common.exception.model.ValidationException;
import domain.Ladder;
import domain.LadderHeight;
import domain.PlayerName;
import domain.PlayerNames;
import view.InputView;
import view.OutputView;

import java.util.Arrays;
import java.util.List;

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
        int pointCount = playerNames.getCount() - 1;
        return Ladder.of(ladderHeight, pointCount);
    }


    public PlayerNames readPlayerNames() {
        return createPlayerNames(inputView.readPlayerNames());
    }


    public PlayerNames createPlayerNames(String playerNamesInput) {
        playerNamesInput = playerNamesInput.replace(InputView.BLANK_SPACE, InputView.BLANK_EMPTY);

        validatePlayerNamesInput(playerNamesInput);

        List<PlayerName> playerNames = Arrays.stream(playerNamesInput.split(","))
                .map(PlayerName::new)
                .toList();

        return new PlayerNames(playerNames);
    }

    private void validatePlayerNamesInput(String playerNamesInput) {
        if (!InputView.PLAYER_NAMES_INPUT_PATTERN.matcher(playerNamesInput).matches()) {
            throw new ValidationException(ExceptionMessage.PLAYER_NAMES_INPUT_FORMAT);
        }
    }

    public LadderHeight readLadderHeight() {
        return new LadderHeight(inputView.readLadderHeight());
    }
}
