package controller;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

import domain.BooleanGenerator;
import domain.Height;
import domain.ladder.Ladder;
import domain.name.PlayerName;
import domain.name.Players;
import java.util.List;
import view.InputView;
import view.OutputView;

public class LadderGame {
    private final BooleanGenerator booleanGenerator;

    public LadderGame(BooleanGenerator booleanGenerator) {
        this.booleanGenerator = booleanGenerator;
    }

    public void run() {
        try {
            Players players = generatePlayers();
            Height height = generateHeight();
            Ladder ladder = generateLadder(players, height);

            OutputView.printPlayerNames(players);
            OutputView.printLadder(players.findMaxNameLength(), ladder);
        } catch (Exception e) {
            OutputView.printErrorMessage(e);
        }
    }

    private Players generatePlayers() {
        List<String> names = InputView.inputPlayerNames();
        return names.stream()
                .map(PlayerName::new)
                .collect(collectingAndThen(toList(), Players::new));
    }

    private Height generateHeight() {
        int height = InputView.inputHeight();
        return new Height(height);
    }

    private Ladder generateLadder(Players players, Height height) {
        return Ladder.create(height, players.getPlayerCount(), booleanGenerator);
    }
}
