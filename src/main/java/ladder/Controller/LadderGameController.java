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
        List<String> names = inputView.readNames();
        List<PlayerName> playerNames = names.stream().map(PlayerName::new).collect(Collectors.toList());

        Height height = new Height(inputView.readHeight());

        LadderGame ladderGame = new LadderGame(playerNames, new RandomLineCreateDecider());
        ladderGame.generateLadder(height);

        outputView.printPlayerNames(playerNames.stream().map(PlayerName::getPlayerName).collect(Collectors.toList()));

        Ladder ladder = ladderGame.getLadder();
        List<Row> rows = ladder.getRows();
        for (Row row : rows) {
            outputView.printRow(row.getPoints());

        }

    }


}
