package controller;

import common.exception.message.ExceptionMessage;
import common.exception.model.ValidationException;
import domain.Ladder;
import domain.LadderHeight;
import domain.PlayerName;
import domain.PlayerNames;
import domain.bridge.strategy.RandomBridgeGenerator;
import java.util.Arrays;
import java.util.List;
import view.InputView;
import view.OutputView;

public class LadderController extends Controller {

    public LadderController(InputView inputView, OutputView outputView) {
        super(inputView, outputView);
    }

    public Ladder createLadder() {
        PlayerNames playerNames = readPlayerNames();
        LadderHeight ladderHeight = readLadderHeight();
        int pointCount = calculatePointCount(playerNames);
        Ladder ladder = Ladder.of(ladderHeight, pointCount, new RandomBridgeGenerator());
        outputView.printLadder(playerNames, ladder);
        return ladder;
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
