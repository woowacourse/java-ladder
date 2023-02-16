package controller;

import domain.Height;
import domain.LadderGame;
import domain.Person;
import domain.Persons;
import exception.ErrorCode;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import view.InputView;
import view.OutputView;

public class LadderController {
    private static final String NAME_DELIMITER = ",";
    private final InputView inputView;
    private final OutputView outputView;
    private LadderGame ladderGame;

    public LadderController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void play() {
        Persons persons = requestPlayerName();
        Height height = requestLadderHeight();

        ladderGame = new LadderGame(persons, height);
        ladderGame.run();
        outputView.printLadder(ladderGame.getAllPlayers(), ladderGame.getLadderStatus(), persons.getLongestPersonNameLength());
    }

    private Persons requestPlayerName() {
        try {
            String inputNames = inputView.requestNames();
            List<Person> personNames = Arrays.stream(inputNames.split(NAME_DELIMITER))
                    .map(Person::new)
                    .collect(Collectors.toList());
            return new Persons(personNames);
        } catch (IllegalArgumentException exception) {
            outputView.printErrorMessage(exception.getMessage());
            return requestPlayerName();
        }
    }

    private Height requestLadderHeight() {
        try {
            return new Height(validateNumber(inputView.requestLadderHeight()));
        } catch (IllegalArgumentException exception) {
            outputView.printErrorMessage(exception.getMessage());
            return requestLadderHeight();
        }
    }

    private int validateNumber(String height) {
        try {
            return Integer.parseInt(height);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(ErrorCode.NUMBER_NOT_INTEGER.getMessage());
        }
    }
}
