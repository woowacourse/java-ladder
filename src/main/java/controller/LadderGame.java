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
import java.util.regex.Pattern;

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


    public PlayerNames createPlayerNames(String playerNameInput) {
        playerNameInput = playerNameInput.replace(" ", "");

        Pattern regex = Pattern.compile("[가-힣a-zA-Z]{1,5}(,[가-힣a-zA-Z]{1,5})*");
        if (!regex.matcher(playerNameInput).matches()) {
            throw new ValidationException(ExceptionMessage.PLAYER_NAMES_INPUT_FORMAT);
        }

        List<PlayerName> playerNames = Arrays.stream(playerNameInput.split(","))
                .map(PlayerName::new)
                .toList();

        return new PlayerNames(playerNames);
    }

    public LadderHeight readLadderHeight() {
        return new LadderHeight(inputView.readLadderHeight());
    }
}
