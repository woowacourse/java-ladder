package ladder.controller;

import java.util.function.Supplier;
import ladder.domain.ladder.Ladder;
import ladder.domain.ladder.LadderHeight;
import ladder.domain.ladder.generator.BooleanGenerator;
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
        final LadderHeight ladderHeight = retryOnException(this::readLadderHeight);

        final Ladder ladder = new Ladder(players.getSize(), ladderHeight, booleanGenerator);

        printLadder(players, ladder);
    }

    public Players readPlayers() {
        final PlayerNamesRequest dto = inputView.readPlayerNames();
        return dto.toPlayers();
    }

    public LadderHeight readLadderHeight() {
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
