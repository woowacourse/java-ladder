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

public class LadderGame extends Controller {

    public LadderGame(InputView inputView, OutputView outputView) {
        super(inputView, outputView);
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
        return retry(() -> createPlayerNames(inputView.readPlayerNames()));
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
        return retry(() -> new LadderHeight(inputView.readLadderHeight()));
    }
}
