package controller;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

import domain.height.Height;
import domain.ladder.Ladder;
import domain.ladder.LadderRungGenerator;
import domain.player.Name;
import domain.player.Players;
import java.util.List;
import view.InputView;
import view.OutputView;

public class LadderGame {
    private final LadderRungGenerator ladderRungGenerator;

    public LadderGame(LadderRungGenerator ladderRungGenerator) {
        this.ladderRungGenerator = ladderRungGenerator;
    }

    public void run() {
        try {
            Players players = generatePlayers();
            Height height = generateHeight();
            Ladder ladder = Ladder.create(height, players, ladderRungGenerator);
            OutputView.printResultMessage();
            OutputView.printPlayerNames(players);
            OutputView.printLadder(players.findMaxNameLength(), ladder);
        } catch (Exception e) {
            OutputView.printErrorMessage(e);
        }
    }

    private Players generatePlayers() {
        List<String> names = InputView.inputPlayerNames();
        return names.stream()
                .map(Name::new)
                .collect(collectingAndThen(toList(), Players::new));
    }

    private Height generateHeight() {
        int height = InputView.inputHeight();
        return new Height(height);
    }
}
