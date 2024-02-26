package controller;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

import domain.booleanGenerator.BooleanGenerator;
import domain.ladder.Height;
import domain.ladder.Ladder;
import domain.player.Name;
import domain.player.Players;
import java.util.List;
import view.InputView;
import view.OutputView;

public class LadderController {
    private final BooleanGenerator booleanGenerator;

    public LadderController(BooleanGenerator booleanGenerator) {
        this.booleanGenerator = booleanGenerator;
    }

    public void run() {
        try {
            final Players players = generatePlayers();
            final Height height = generateHeight();
            final Ladder ladder = generateLadder(players, height);

            OutputView.printPlayerNames(players);
            OutputView.printLadder(ladder, players.findMaxNameLength());
        } catch (Exception e) {
            OutputView.printErrorMessage(e);
        }
    }

    private Players generatePlayers() {
        final List<String> names = InputView.inputPlayerNames();
        return names.stream()
                .map(Name::new)
                .collect(collectingAndThen(toList(), Players::new));
    }

    private Height generateHeight() {
        final int height = InputView.inputHeight();
        return new Height(height);
    }

    private Ladder generateLadder(Players players, Height height) {
        return new Ladder(booleanGenerator, height, players.getPlayerCount());
    }
}
