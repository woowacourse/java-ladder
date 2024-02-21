package ladder.controller;

import java.util.List;
import java.util.function.Supplier;
import ladder.domain.generator.BooleanGenerator;
import ladder.domain.ladder.Height;
import ladder.domain.ladder.Ladder;
import ladder.domain.player.Players;
import ladder.dto.LadderDto;
import ladder.dto.PlayersDto;
import ladder.utils.Converter;
import ladder.view.InputView;
import ladder.view.OutputView;

public class LadderController {
    private final InputView inputView;
    private final OutputView outputView;
    private final BooleanGenerator booleanGenerator;

    public LadderController(InputView inputView, OutputView outputView, BooleanGenerator booleanGenerator) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.booleanGenerator = booleanGenerator;
    }

    public void run() {
        Players players = retryOnException(this::readPlayers);
        Height height = retryOnException(this::readLadderHeight);
        int columnSize = players.countPlayers();

        Ladder ladder = new Ladder(columnSize, height, booleanGenerator);

        printLadder(players, ladder);
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

    private void printLadder(Players players, Ladder ladder) {
        outputView.printLadderResultMessage();
        outputView.printPlayerNames(PlayersDto.from(players));
        outputView.printLadder(LadderDto.from(ladder));
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
