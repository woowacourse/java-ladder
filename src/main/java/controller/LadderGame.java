package controller;

import domain.height.Height;
import domain.ladder.Ladder;
import domain.ladder.LadderResult;
import domain.player.Players;
import domain.prize.Prizes;
import generator.BooleanGenerator;
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
            Prizes prizes = generatePrizes(players);
            Height height = generateHeight();
            Ladder ladder = Ladder.create(height, players, booleanGenerator);
            OutputView.printLadder(ladder, players, prizes);
            LadderResult result = ladder.climb(players, prizes);
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

    private Prizes generatePrizes(Players players) {
        List<String> prizeNames = InputView.inputPrizeNames();
        return Prizes.of(prizeNames, players);
    }
}
