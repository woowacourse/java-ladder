package controller;

import static message.ErrorMessage.INVALID_LADDER_LANGUAGE_EXCEPTION;

import domain.Ladder;
import domain.Players;
import view.InputView;
import view.OutputView;

public class LadderController {

    public LadderController() {
    }

    public void run() {
        Players players = readPlayers();
        Ladder ladder = readLadder(players);
        OutputView.printResult(players, ladder);
    }

    private Ladder readLadder(Players players) {
        try {
            return Ladder.from(InputView.readLadderHeight(), getWidth(players));
        } catch (NumberFormatException e) {
            System.out.println(INVALID_LADDER_LANGUAGE_EXCEPTION.getMessage());
            return readLadder(players);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readLadder(players);
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
