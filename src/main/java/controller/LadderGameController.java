package controller;

import domain.Height;
import domain.Ladder;
import domain.Lines;
import domain.Players;
import java.util.List;
import view.InputView;
import view.OutputView;

public class LadderGameController {

    private final InputView inputView;
    private final OutputView outputView;

    public LadderGameController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void run() {
        Players players = makePlayers();
        Ladder ladder = makeLadder(players.findNumberOfPlayers());

        outputView.printResult(players, ladder);
    }

    private Players makePlayers() {
        try {
            List<String> playerNames = inputView.readPlayerNames();
            return new Players(playerNames);
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            return makePlayers();
        }
    }

    private Ladder makeLadder(int numberOfPlayers) {
        try {
            int ladderHeight = inputView.readHeight();
            Ladder ladder = new Ladder(new Lines(numberOfPlayers, ladderHeight), new Height(ladderHeight));
            return ladder;
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            return makeLadder(numberOfPlayers);
        }
    }
}
