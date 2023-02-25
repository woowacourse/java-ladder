package controller;

import domain.Height;
import domain.LadderGame;
import domain.Person;
import domain.Persons;
import domain.WinningEntry;
import domain.WinningResult;
import exception.ErrorCode;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;
import util.ExceptionTemplate;
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
        WinningEntry winningEntry = requestGameResult(persons.getTotalPersonCount());
        Height height = requestLadderHeight();

        ladderGame = new LadderGame(persons, height, winningEntry, new RandomBooleanGenerator());
        outputView.printLadder(ladderGame.getAllPlayers(), ladderGame.getLadder(), ladderGame.getWinningEntries(),
                persons.getLongestPersonNameLength());
        printGameResult(ladderGame.play());
    }

    private Persons requestPlayerName() {
        return ExceptionTemplate.reInputIfException(
                () -> new Persons(Arrays.stream(inputView.requestNames().split(DELIMITER))
                        .map(Person::new)
                        .collect(Collectors.toList()))
        );
    }

    private Height requestLadderHeight() {
        return ExceptionTemplate.reInputIfException(
                () -> new Height(inputView.requestLadderHeight())
        );
    }

    private WinningEntry requestGameResult(int personCount) {
        return ExceptionTemplate.reInputIfException(
                () -> new WinningEntry(Arrays.stream(inputView.requestGameResult().split(DELIMITER))
                        .map(WinningResult::new)
                        .collect(Collectors.toList()), personCount)
        );
    }

    private void printGameResult(Map<String, String> result) {
        boolean isGameEnd = false;
        while (!isGameEnd) {
            isGameEnd = isAllPrinted(result);
        }
    }

    private boolean isAllPrinted(Map<String, String> result) {
        try {
            return printRequestedResult(inputView.requestResultTarget(), result);
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        }
        return false;
    }

    private boolean printRequestedResult(String target, Map<String, String> results) {
        if (target.equals(ALL_RESULT)) {
            outputView.printTotalResult(results);
            return true;
        }
        if (results.containsKey(target)) {
            outputView.printSingleResult(results.get(target));
            return false;
        }
        throw new IllegalArgumentException(ErrorCode.WRONG_RESULT_TARGET.getMessage());
    }
}
