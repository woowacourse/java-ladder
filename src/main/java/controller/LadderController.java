package controller;

import java.util.List;

import domain.BooleanGenerator;
import domain.Ladder;
import domain.Name;
import domain.Names;
import domain.RandomBooleanGenerator;
import utils.Log;
import view.InputView;
import view.OutputView;

public class LadderController {

    public void run() {
        Names names = generateNames();
        Names results = generateResults();
        Ladder ladder = generateLadder(names.getPersonCount());

        OutputView.printNames(names);
        OutputView.printLadder(ladder);

        while (true) {
            Name name = generateName();
            if (name.getName().equals("all")) {
                for (int i = 0; i < names.getNames().size(); i++) {
                    int result = ladder.move(i);
                    System.out.printf("%s : %s%n", names.getNames().get(i).getName(), results.getNames().get(result).getName());
                }
                break;
            }
            try {
                int index = names.findByName(name.getName());
                int result = ladder.move(index);
                System.out.println(results.getNames().get(result).getName());
            } catch (IllegalArgumentException exception) {
                Log.log(exception.getMessage());
            }
        }
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

    private Names generateResults() {
        try {
            List<String> names = InputView.readResults();
            return new Names(names);
        } catch (IllegalArgumentException exception) {
            Log.log(exception.getMessage());
            return generateResults();
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

    private Name generateName() {
        try {
            String name = InputView.readName();
            return new Name(name);
        } catch (IllegalArgumentException exception) {
            Log.log(exception.getMessage());
            return generateName();
        }
    }
}
