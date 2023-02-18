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
        Players players = generatePlayers();
        Height height = generateHeight();

        LadderGenerator ladderGenerator = new LadderGenerator(new RandomLineCreateDecider());
        showResult(players, ladderGenerator.generateLadder(players.size(), height));
    }

    private Players generatePlayers() {
        try{
            List<String> names = inputView.readNames();
            return new Players(names.stream()
                    .map(Player::new)
                    .collect(Collectors.toList()));
        }catch(IllegalArgumentException exception){
            outputView.printExceptionMessage(exception.getMessage());
            return generatePlayers();
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

    private void showResult(Players players, Ladder ladder) {
        outputView.printPlayerNames(players.getPlayers().stream()
                .map(Player::getPlayerName)
                .collect(Collectors.toList()));

        List<Row> rows = ladder.getRows();
        for (Row row : rows) {
            outputView.printRow(row.getPoints());
        }
    }

}
