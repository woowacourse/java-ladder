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
        Ladder ladder = readLadder();

        int ladderWidth = players.getPlayers().size() - 1;
        ladder.makeLines(ladderWidth);

        OutputView.printResult(players, ladder);
    }

    private Ladder readLadder() {
        try {
            return new Ladder(InputView.readLadderHeight());
        } catch (NumberFormatException e) {
            System.out.println(INVALID_LADDER_LANGUAGE_EXCEPTION.getMessage());
            return readLadder();
        } catch (IllegalArgumentException e) {
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
}
