package ladder.controller;

import ladder.domain.generator.BooleanGenerator;
import ladder.domain.ladder.Height;
import ladder.domain.ladder.Ladder;
import ladder.domain.ladder.LadderGenerator;
import ladder.domain.player.Players;
import ladder.dto.LadderDto;
import ladder.dto.PlayersDto;
import ladder.utils.Converter;
import ladder.view.InputView;
import ladder.view.OutputView;

import java.util.List;
import java.util.function.Supplier;

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
        final LadderGenerator ladderGenerator = new LadderGenerator(booleanGenerator);

        final Players players = retryOnException(this::readPlayers);
        final Height height = retryOnException(this::readLadderHeight);

        final Ladder ladder = ladderGenerator.generate(players, height);
        printLadder(players, ladder);
    }

    public Players readPlayers() {
        final String input = inputView.readPlayerNames();
        final List<String> playerNames = Converter.stringToList(input);

        return new Players(playerNames);
    }

    public Height readLadderHeight() {
        final int height = inputView.readLadderHeight();

        return new Height(height);
    }

    private void printLadder(final Players players, final Ladder ladder) {
        outputView.printLadderResultMessage();
        outputView.printPlayerNames(PlayersDto.from(players));
        outputView.printLadder(LadderDto.from(ladder));
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
