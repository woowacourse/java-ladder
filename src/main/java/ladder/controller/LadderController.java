package ladder.controller;

import java.util.function.Supplier;
import ladder.domain.generator.BooleanGenerator;
import ladder.domain.ladder.Height;
import ladder.domain.ladder.Ladder;
import ladder.domain.player.Players;
import ladder.dto.request.LadderHeightRequest;
import ladder.dto.request.PlayerNamesRequest;
import ladder.dto.response.LadderResponse;
import ladder.dto.response.PlayersResponse;
import ladder.view.InputView;
import ladder.view.OutputView;

public class LadderController {
    private final InputView inputView;
    private final OutputView outputView;
    private final BooleanGenerator booleanGenerator;

    public LadderController(final InputView inputView,
                            final OutputView outputView,
                            final BooleanGenerator booleanGenerator) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.booleanGenerator = booleanGenerator;
    }

    public void run() {
        final Players players = retryOnException(this::readPlayers);
        final Height height = retryOnException(this::readLadderHeight);
        final int columnSize = players.getSize();

        final Ladder ladder = new Ladder(columnSize, height, booleanGenerator);

        printLadder(players, ladder);
    }

    public Players readPlayers() {
        final PlayerNamesRequest dto = inputView.readPlayerNames();
        return dto.toPlayers();
    }

    public Height readLadderHeight() {
        final LadderHeightRequest dto = inputView.readLadderHeight();
        return dto.toHeight();
    }

    private void printLadder(final Players players, final Ladder ladder) {
        outputView.printLadderResultMessage();
        outputView.printPlayerNames(PlayersResponse.from(players));
        outputView.printLadder(LadderResponse.from(ladder));
    }

    private <T> T retryOnException(final Supplier<T> supplier) {
        try {
            return supplier.get();
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e.getMessage());
            return retryOnException(supplier);
        }
    }
}
