package ladder.controller;

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
        try {
            List<Player> players = generatePlayers();
            Height height = generateHeight();

            LadderGame ladderGame = new LadderGame(players, height, new RandomLineCreateDecider());
            showResult(ladderGame);
        } catch (IllegalArgumentException e) {
            outputView.printError(e.getMessage());
        }
    }

    private List<Player> generatePlayers() {
        List<String> names = inputView.readNames();
        List<Player> players = names.stream()
                .map(Player::new)
                .collect(Collectors.toList());
        return players;
    }

    private Height generateHeight() {
        int height = inputView.readHeight();
        return new Height(height);
    }

    private void showResult(LadderGame ladderGame) {
        outputView.printPlayerNames(ladderGame.getPlayers().stream()
                .map(Player::getPlayerName)
                .map(PlayerName::getPlayerName)
                .collect(Collectors.toList()));

        Ladder ladder = ladderGame.getLadder();
        List<Row> rows = ladder.getRows();
        for (Row row : rows) {
            outputView.printRow(row.getPoints());
        }
    }

}
