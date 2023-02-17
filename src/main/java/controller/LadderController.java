package controller;

import java.util.List;

import domain.Ladder;
import domain.Players;
import utils.Log;
import view.InputView;
import view.OutputView;

public class LadderController {

    public void run() {
        Players players = generatePlayers();
        Ladder ladder = generateLadder(players.getPlayerSize());
        OutputView.printNames(players);
        OutputView.printLadder(ladder);
    }

    private Players generatePlayers() {
        try {
            List<String> names = InputView.readNames();
            return new Players(names);
        } catch (IllegalArgumentException exception) {
            Log.log(exception.getMessage());
            return generatePlayers();
        }
    }

    private Ladder generateLadder(int personCount) {
        try {
            int height = InputView.readHeight();
            return new Ladder(height, personCount);
        } catch (IllegalArgumentException exception) {
            Log.log(exception.getMessage());
            return generateLadder(personCount);
        }
    }
}
