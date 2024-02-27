package controller;

import domain.ladder.Ladder;
import domain.ladder.LadderHeight;
import domain.player.PlayerName;
import domain.player.PlayerNames;
import domain.ladder.strategy.RandomBridgeGenerator;
import java.util.List;
import view.InputView;
import view.OutputView;

public class LadderController {
    private final InputView inputView;
    private final OutputView outputView;
    private final RetryHandler retryHandler;

    public LadderController(final InputView inputView, final OutputView outputView, final RetryHandler retryHandler) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.retryHandler = retryHandler;
    }

    public Ladder createLadder() {
        PlayerNames playerNames = readPlayerNames();
        LadderHeight ladderHeight = readLadderHeight();
        Ladder ladder = Ladder.of(ladderHeight, playerNames, new RandomBridgeGenerator());
        outputView.printLadder(playerNames, ladder);
        return ladder;
    }

    private PlayerNames readPlayerNames() {
        return retryHandler.retry(() -> createPlayerNames(inputView.readPlayerNames()));
    }

    private PlayerNames createPlayerNames(final List<String> splitPlayerNames) {
        List<PlayerName> playerNames = splitPlayerNames.stream()
                .map(PlayerName::new)
                .toList();

        return new PlayerNames(playerNames);
    }

    private LadderHeight readLadderHeight() {
        return retryHandler.retry(() -> new LadderHeight(inputView.readLadderHeight()));
    }
}
