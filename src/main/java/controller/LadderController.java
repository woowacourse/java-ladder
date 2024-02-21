package controller;

import domain.Ladder;
import domain.Players;
import view.InputView;
import view.OutputView;

public class LadderController {

    public LadderController() {
    }

    public void run() {
        Players players = readPlayers();
        Ladder ladder = readLadder();
        ladder.makeLines(getWidth(players));
        OutputView.printResult(players, ladder);
    }

    private Ladder readLadder() {
        try {
            return new Ladder(InputView.readLadderHeight());
        }
        catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            return readLadder();
        }
    }

    private Players readPlayers() {
        try {
            return new Players(InputView.readPlayerNames());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readPlayers();
        }
    }

    private int getWidth(Players players) {
        return players.getPlayers().size() - 1;
    }
}
