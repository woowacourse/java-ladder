package controller;

import java.util.List;

import domain.Ladder;
import domain.Names;
import utils.Log;
import view.InputView;
import view.OutputView;

public class LadderController {

    public void run() {
        Names names = generateNames();
        Ladder ladder = generateLadder(names.getPersonCount());
        OutputView.printNames(names);
        OutputView.printLadder(ladder);
    }

    private Names generateNames() {
        try {
            List<String> names = InputView.readNames();
            return new Names(names);
        } catch (IllegalArgumentException exception) {
            Log.log(exception.getMessage());
            return generateNames();
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
