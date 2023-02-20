package controller;

import java.util.List;

import domain.Ladder;
import domain.Names;
import utils.Log;
import view.InputView;
import view.OutputView;

public class LadderController {

    public void run() {
        Names names = generatePlayers();
        Ladder ladder = generateLadder(names.getNamesSize());
        OutputView.printNames(names);
        OutputView.printLadder(ladder);
    }

    private Names generatePlayers() {
        try {
            List<String> names = InputView.readNames();
            return new Names(names);
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
