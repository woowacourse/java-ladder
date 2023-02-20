package controller;

import domain.Height;
import domain.Ladder;
import domain.Players;
import util.LineGenerator;
import util.RandomLineGenerator;
import view.InputView;
import view.OutputView;

public class LadderController {

    public void run() {
        Players players = makePlayers();
        Ladder ladder = makeLadder(players);
        printLadder(players, ladder);
    }

    private Players makePlayers() {
        try {
            String playerNames = InputView.receivePlayer();
            return new Players(playerNames);
        } catch (IllegalArgumentException e) {
            OutputView.printMessage(e.getMessage());
            return makePlayers();
        }
    }

    private Ladder makeLadder(Players players) {
        LineGenerator lineGenerator = new RandomLineGenerator();
        try {
            int height = InputView.receiveHeight();
            return new Ladder(players.getNumberOfPlayers(), new Height(height), lineGenerator);
        } catch (IllegalArgumentException e) {
            OutputView.printMessage(e.getMessage());
            return makeLadder(players);
        }
    }

    private void printLadder(Players players, Ladder ladder) {
        OutputView.printResultMessage();
        OutputView.printPlayers(players);
        OutputView.printLadder(ladder);
    }
}
