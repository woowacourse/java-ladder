package controller;

import domain.Height;
import domain.LadderGame;
import domain.Person;
import domain.Persons;
import domain.WinningEntry;
import exception.ErrorCode;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import util.RandomBooleanGenerator;
import view.InputView;
import view.OutputView;

public class LadderController {
    private static final String DELIMITER = ",";
    private static final String ALL_RESULT = "all";
    private static final InputView inputView = new InputView();
    private static final OutputView outputView = new OutputView();
    private LadderGame ladderGame;

    public LadderController() {
    }

    public void play() {
        Persons persons = requestPlayerName();
        Height height = requestLadderHeight();
        WinningEntry winningEntry = requestGameResult(persons.getTotalPersonCount());

        ladderGame = new LadderGame(persons, height, winningEntry, new RandomBooleanGenerator());
        outputView.printLadder(ladderGame.getAllPlayers(), ladderGame.getLadder(), winningEntry.getWinningEntry(),
                persons.getLongestPersonNameLength());
        printGameResult(ladderGame.play());
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
            List<Person> personNames = Arrays.stream(inputView.requestNames().split(DELIMITER))
                    .map(Person::new)
                    .collect(Collectors.toList());
            return new Persons(personNames);
        } catch (IllegalArgumentException exception) {
            outputView.printErrorMessage(exception.getMessage());
        }
        return null;
    }

    private Height requestLadderHeight() {
        Height height = null;
        while (height == null) {
            height = readHeight();
        }
        return height;
    }

    private Height readHeight() {
        try {
            return new Height(inputView.requestLadderHeight());
        } catch (IllegalArgumentException exception) {
            outputView.printErrorMessage(exception.getMessage());
        }
        return null;
    }

    private WinningEntry requestGameResult(int personCount) {
        while(true) {
            try {
                return new WinningEntry(Arrays.stream(inputView.requestGameResult().split(DELIMITER)).collect(Collectors.toList()), personCount);
            } catch (IllegalArgumentException exception) {
                outputView.printErrorMessage(exception.getMessage());
            }
        }
    }

    private void printGameResult(Map<String, String> result) {
        boolean isGameEnd = false;
        while (!isGameEnd) {
            isGameEnd = isAllPrinted(result);
        }
    }

    private boolean isAllPrinted(Map<String, String> result) {
        try {
            return printResult(inputView.requestResultTarget(), result);
        } catch (IllegalArgumentException exception) {
            outputView.printErrorMessage(exception.getMessage());
        }
        return false;
    }

    private boolean printResult(String target, Map<String, String> result) {
        if (target.equals(ALL_RESULT)) {
            outputView.printResult(result);
            return true;
        }
        if (result.containsKey(target)) {
            outputView.printResult(result.get(target));
            return false;
        }
        throw new IllegalArgumentException(ErrorCode.WRONG_RESULT_TARGET.getMessage());
    }
}
