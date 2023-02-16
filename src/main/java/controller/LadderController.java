package controller;

import domain.Height;
import domain.Ladder;
import domain.Players;
import view.InputView;
import view.OutputView;

public class LadderController {

    public void run() {
        Players players = makePlayers();
        Ladder ladder = makeLadder(players);
        printLadder(players, ladder);
    }

    private Players makePlayers() {
        String playerNames =  InputView.receivePlayer();
        return new Players(playerNames);
    }

    private Ladder makeLadder(Players players) {
        int height = InputView.receiveHeight();
        return new Ladder(players.getNumberOfPlayers(), new Height(height));
    }

    private void printLadder(Players players, Ladder ladder) {
        OutputView.printResultMessage();
        OutputView.printPlayers(players);
        OutputView.printLadder(ladder);
    }

}
