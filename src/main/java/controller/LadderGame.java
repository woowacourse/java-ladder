package controller;

import domain.Ladder;
import domain.LadderHeight;
import domain.PlayerName;
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
        List<PlayerName> playerNames = readPlayerNames();
        LadderHeight ladderHeight = readLadderHeight();

        Ladder ladder = createLadder(playerNames, ladderHeight);
        outputView.printResult(playerNames, ladder);
    }

    private Ladder createLadder(List<PlayerName> playerNames, LadderHeight ladderHeight) {
        int pointCount = playerNames.size() - 1;
        return Ladder.of(ladderHeight, pointCount);
    }


    public List<PlayerName> readPlayerNames() {
        return createPlayerNames(inputView.readPlayerNames());
    }


    public List<PlayerName> createPlayerNames(String playerNameInput) {
        playerNameInput = playerNameInput.replace(" ", "");

        Pattern regex = Pattern.compile("[가-힣a-zA-Z]{1,5}(,[가-힣a-zA-Z]{1,5})*");
        if (!regex.matcher(playerNameInput).matches()) {
            throw new IllegalArgumentException();
        }

        return Arrays.stream(playerNameInput.split(","))
                .map(PlayerName::new)
                .toList();
    }

    public LadderHeight readLadderHeight() {
        return new LadderHeight(inputView.readLadderHeight());
    }
}
