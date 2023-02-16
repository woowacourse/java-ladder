package ladder.Controller;

import ladder.model.*;
import ladder.view.InputView;
import ladder.view.OutputView;

import java.util.List;
import java.util.stream.Collectors;

public class LadderGameController {

    private final InputView inputView;
    private final OutputView outputView;

    public LadderGameController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        List<PlayerName> playerNames = generatePlayerNames();
        Height height = generateHeight();

        LadderGame ladderGame = new LadderGame(playerNames, new RandomLineCreateDecider());
        ladderGame.generateLadder(height);
        showResult(ladderGame);
    }

    private Height generateHeight() {
        int height = inputView.readHeight();
        return new Height(height);
    }

    private List<PlayerName> generatePlayerNames() {
        List<String> names = inputView.readNames();
        List<PlayerName> playerNames = names.stream()
                .map(PlayerName::new)
                .collect(Collectors.toList());
        return playerNames;
    }

    private void showResult(LadderGame ladderGame) {
        outputView.printPlayerNames(ladderGame.getPlayerNames().stream()
                .map(PlayerName::getPlayerName)
                .collect(Collectors.toList()));

        Ladder ladder = ladderGame.getLadder();
        List<Row> rows = ladder.getRows();
        for (Row row : rows) {
            outputView.printRow(row.getPoints());
        }
    }

}
