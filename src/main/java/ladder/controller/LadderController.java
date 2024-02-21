package ladder.controller;

import java.util.List;
import java.util.function.Supplier;
import ladder.domain.ladder.Height;
import ladder.domain.player.Players;
import ladder.utils.Converter;
import ladder.view.InputView;
import ladder.view.OutputView;

public class LadderController {
    private final InputView inputView;
    private final OutputView outputView;

    public LadderController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        Players players = retryOnException(this::readPlayers);
        Height height = retryOnException(this::readLadderHeight);
    }

    public Players readPlayers() {
        String input = inputView.readPlayerNames();
        List<String> playerNames = Converter.stringToList(input);
        return new Players(playerNames);
    }

    public Height readLadderHeight() {
        int height = inputView.readLadderHeight();
        return new Height(height);
    }

    private <T> T retryOnException(Supplier<T> supplier) {
        try {
            return supplier.get();
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e.getMessage());
            return retryOnException(supplier);
        }
    }
}
