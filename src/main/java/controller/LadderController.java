package controller;

import java.util.List;

import domain.BooleanGenerator;
import domain.Ladder;
import domain.Names;
import domain.RandomBooleanGenerator;
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
            BooleanGenerator booleanGenerator = new RandomBooleanGenerator();
            int height = InputView.readHeight();
            return new Ladder(booleanGenerator, height, personCount);
        } catch (IllegalArgumentException exception) {
            Log.log(exception.getMessage());
            return generateLadder(personCount);
        }
    }
}
