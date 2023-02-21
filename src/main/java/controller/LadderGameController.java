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

public class LadderGameController {
    private static final String DELIMITER = ",";
    private final InputView inputView;
    private final OutputView outputView;
    private LadderGame ladderGame;

    public LadderGameController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void play() {
        Persons persons = requestPlayerName();
        Height height = requestLadderHeight();
        List<String> results = requestLadderResult();

        ladderGame = new LadderGame(persons, height, results);
        ladderGame.run();
        outputView.printLadder(ladderGame.getAllPlayers(), ladderGame.getLadderStatus(),
                persons.getLongestPersonNameLength());
    }

    private Persons requestPlayerName() {
        try {
            String inputNames = inputView.requestNames();
            List<Person> personNames = Arrays.stream(inputNames.split(DELIMITER))
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
            return new Height(validateNumber(inputView.requestHeight()));
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

    private List<String> requestLadderResult() {
        try {
            String inputResults = inputView.requestResult();
            List<String> results = Arrays.stream(inputResults.split(DELIMITER))
                    .collect(Collectors.toList());
            return results;
        } catch (IllegalArgumentException exception) {
            outputView.printErrorMessage(exception.getMessage());
            return requestLadderResult();
        }
    }
}
