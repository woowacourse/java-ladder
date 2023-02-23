package controller;

import domain.Height;
import domain.Ladder;
import domain.Players;
import util.BooleanGenerator;
import util.RandomBooleanGenerator;
import view.InputView;
import view.OutputView;

public class LadderController {

    public void run() {
        Players players = makePlayers();
        Ladder ladder = makeLadder(players);
        ladder.generateRandomLadder();
        printLadder(players, ladder);
    }

    private Players makePlayers() {
        try {
            String[] playerNames = InputView.receivePlayer();
            return Players.of(playerNames);
        } catch (IllegalArgumentException e) {
            OutputView.printMessage(e.getMessage());
            return makePlayers();
        }
    }

    private Ladder makeLadder(Players players) {
        BooleanGenerator booleanGenerator = new RandomBooleanGenerator();
        try {
            int height = InputView.receiveHeight();
            return Ladder.makeDefaultLadder(players.getNumberOfPlayers(), new Height(height).getHeight(), booleanGenerator);
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
