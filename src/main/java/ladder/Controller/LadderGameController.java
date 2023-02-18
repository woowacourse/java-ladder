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
        List<Player> players = generatePlayerNames();
        Height height = generateHeight();

        LadderGame ladderGame = generateLadderGame(players, height);
        showResult(ladderGame);
    }

    private List<Player> generatePlayerNames() {
        try{
            List<String> names = inputView.readNames();
            List<Player> players = names.stream()
                    .map(Player::new)
                    .collect(Collectors.toList());
            return players;
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

    private LadderGame generateLadderGame(List<Player> players, Height height) {
        try{
            return new LadderGame(players, height, new RandomLineCreateDecider());
        }catch(IllegalArgumentException exception){
            outputView.printExceptionMessage(exception.getMessage());
            List<Player> retryNames = generatePlayerNames();
            Height retryHeight = generateHeight();
            return generateLadderGame(retryNames, retryHeight);
        }
    }

    private void showResult(LadderGame ladderGame) {
        outputView.printPlayerNames(ladderGame.getPlayerNames().stream()
                .map(Player::getPlayerName)
                .collect(Collectors.toList()));

        Ladder ladder = ladderGame.getLadder();
        List<Row> rows = ladder.getRows();
        for (Row row : rows) {
            outputView.printRow(row.getPoints());
        }
    }

}
