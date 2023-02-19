package controller;

import domain.Ladder;
import domain.Persons;
import domain.RandomDigitsGenerator;
import view.InputView;
import view.OutputView;

import java.util.List;

public class LadderGameController {

    private final InputView inputView;
    private final OutputView outputView;
    private final RandomDigitsGenerator generator;

    public LadderGameController(InputView inputView, OutputView outputView, RandomDigitsGenerator generator) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.generator = generator;
    }

    public void run() {
        Persons persons = readPersons();
        Ladder ladder = readLadder(persons.getCount() - 1);

        outputView.printPersonNames(persons.getPersonsName());
        outputView.printLadder(ladder.getLines());
    }

    private Persons readPersons() {
        try {
            List<String> names = inputView.readPersonsName();
            return new Persons(names);
        } catch (IllegalArgumentException e) {
            outputView.printError(e);
            return readPersons();
        }
    }

    private Ladder readLadder(int width) {
        try {
            int height = inputView.readLadderHeight();
            return new Ladder(height, width, generator);
        } catch (IllegalArgumentException e) {
            outputView.printError(e);
            return readLadder(width);
        }
    }
}



