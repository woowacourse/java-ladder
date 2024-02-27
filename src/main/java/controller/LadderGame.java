package controller;

import domain.height.Height;
import domain.ladder.Ladder;
import domain.ladder.LadderRungGenerator;
import domain.player.Players;
import domain.prize.Prizes;
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
            Prizes prizes = generatePrizes();
            Ladder ladder = Ladder.create(height, players, prizes, ladderRungGenerator);
            OutputView.printResultMessage();
            OutputView.printPlayerNames(players);
            OutputView.printLadder(players.findMaxNameLength(), ladder);
        } catch (Exception e) {
            OutputView.printErrorMessage(e);
        }
    }

    private Players generatePlayers() {
        List<String> names = InputView.inputPlayerNames();
        return Players.from(names);
    }

    private Height generateHeight() {
        int height = InputView.inputHeight();
        return new Height(height);
    }

    private Prizes generatePrizes() {
        List<String> rawPrizes = InputView.inputPrizeNames();
        return Prizes.from(rawPrizes);
    }
}
