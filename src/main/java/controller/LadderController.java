package controller;

import domain.Height;
import domain.LadderGame;
import domain.Person;
import domain.Persons;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import view.InputView;
import view.OutputView;

public class LadderController {
    private static final String NAME_DELIMITER = ",";
    private static final InputView inputView = new InputView();
    private static final OutputView outputView = new OutputView();
    private LadderGame ladderGame;

    public LadderController() {
    }

    public void play() {
        Persons persons = requestPlayerName();
        Height height = requestLadderHeight();

        ladderGame = new LadderGame(persons, height);
        ladderGame.run();
        outputView.printLadder(ladderGame.getAllPlayers(), ladderGame.getLadderStatus(),
                persons.getLongestPersonNameLength());
    }

    private Persons requestPlayerName() {
        Persons personNames = null;
        while (personNames == null) {
            personNames = readPersonNames();
        }
        return personNames;
    }

    private Persons readPersonNames() {
        try {
            List<Person> personNames = Arrays.stream(inputView.requestNames().split(NAME_DELIMITER))
                    .map(Person::new)
                    .collect(Collectors.toList());
            return new Persons(personNames);
        } catch (IllegalArgumentException exception) {
            outputView.printErrorMessage(exception.getMessage());
        }
        return null;
    }

    private Height requestLadderHeight() {
        return new Height(inputView.requestLadderHeight());
    }

}
