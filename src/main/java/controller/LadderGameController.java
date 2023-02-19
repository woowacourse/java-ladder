package controller;

import domain.Ladder;
import domain.Persons;
import domain.RandomPointGenerator;
import view.InputView;
import view.OutputView;
import java.util.List;

public class LadderGameController {

    private final InputView inputView;
    private final OutputView outputView;
    private final RandomPointGenerator generator;

    public LadderGameController(InputView inputView, OutputView outputView, RandomPointGenerator generator) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.generator = generator;
    }

    public void run() {
        List<String> names = inputView.readPersonsName();
        int height = inputView.readLadderHeight();
        Persons persons = new Persons(names);
        Ladder ladder = new Ladder(height, names.size(), generator);

        outputView.printPersonNames(persons.getPersonsName());
        outputView.printLadder(ladder.getLines());
    }
}



