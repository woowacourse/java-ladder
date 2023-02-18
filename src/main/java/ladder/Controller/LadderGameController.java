package ladder.Controller;

import ladder.model.*;
import ladder.view.InputView;
import ladder.view.OutputView;

import java.util.ArrayList;
import java.util.Collections;
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

        LadderGame ladderGame = generateLadderGame(playerNames, height);
        showResult(ladderGame);
    }

    private List<PlayerName> generatePlayerNames() {
        try{
            List<String> names = inputView.readNames();
            List<PlayerName> playerNames = names.stream()
                    .map(PlayerName::new)
                    .collect(Collectors.toList());
            return playerNames;
        }catch(IllegalArgumentException exception){
            outputView.printExceptionMessage(exception.getMessage());
            return generatePlayerNames();
        }
    }

    private Height generateHeight() {
        try{
            int height = inputView.readHeight();
            return new Height(height);
        }catch(IllegalArgumentException exception){
            outputView.printExceptionMessage(exception.getMessage());
            return generateHeight();
        }
    }

    private LadderGame generateLadderGame(List<PlayerName> playerNames, Height height) {
        try{
            return new LadderGame(playerNames, height, new RandomLineCreateDecider());
        }catch(IllegalArgumentException exception){
            outputView.printExceptionMessage(exception.getMessage());
            List<PlayerName> retryNames = generatePlayerNames();
            Height retryHeight = generateHeight();
            return generateLadderGame(retryNames, retryHeight);
        }
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
