package controller;

import domain.Ladder;
import domain.Players;
import java.util.List;

import domain.generator.ConnectionGenerator;
import domain.generator.RandomConnectionGenerator;
import view.InputView;
import view.OutputView;

public class LadderGameController {

    private final InputView inputView;
    private final OutputView outputView;
    private final ConnectionGenerator connectionGenerator;

    public LadderGameController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.connectionGenerator = new RandomConnectionGenerator();
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

    private Ladder makeLadder(final int numberOfPlayers) {
        try {
            int ladderHeight = inputView.readHeight();
            return new Ladder(numberOfPlayers, ladderHeight, connectionGenerator);
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            return makeLadder(numberOfPlayers);
        }
    }
}
