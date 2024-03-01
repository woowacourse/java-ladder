package controller;

import domain.height.Height;
import domain.ladder.Ladder;
import domain.ladder.LadderResult;
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
            Prizes prizes = generatePrizes();
            Height height = generateHeight();
            Ladder ladder = Ladder.create(height, players, prizes, ladderRungGenerator);
            OutputView.printLadder(ladder, players, prizes);
            LadderResult result = ladder.climb();
            String name = InputView.inputPlayerNameToFindResult();
            while (!"all".equals(name)) {
                OutputView.printSinglePlayerResult(result.findPrizeByName(name));
                name = InputView.inputPlayerNameToFindResult();
            }
            OutputView.printAllPlayerResult(result.getAllResults());
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
