package controller;

import domain.Height;
import domain.LadderGame;
import domain.Person;
import domain.Persons;
import domain.WinningEntry;
import domain.WinningResult;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;
import util.ExceptionTemplate;
import util.RandomBooleanGenerator;
import view.InputView;
import view.OutputView;

public class LadderController {
    private static final String DELIMITER = ",";
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
            int printedSize = printRequestedResult(inputView.requestResultTarget(), result);
            return result.size() == printedSize;
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        }
        return false;
    }

    private int printRequestedResult(String target, Map<String, String> result) {
        Map<String, String> requestedResult = ladderGame.pickResultForTarget(result, target);
        outputView.printResult(requestedResult);
        return requestedResult.size();
    }
}
