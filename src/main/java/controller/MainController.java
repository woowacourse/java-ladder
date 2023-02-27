package controller;

import domain.LadderGame;
import domain.Result;
import domain.SearchCommand;
import domain.generator.LadderStepGenerator;
import domain.ladder.Height;
import domain.ladder.Ladder;
import domain.mission.Missions;
import domain.player.Names;
import java.util.NoSuchElementException;
import view.InputView;
import view.OutputView;

public class MainController {

    private final InputView inputView;
    private final OutputView outputView;
    private final LadderStepGenerator ladderGenerator;

    public MainController(InputView inputView, OutputView outputView, LadderStepGenerator ladderGenerator) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.ladderGenerator = ladderGenerator;
    }

    public void start() {
        Names names = receiveNames();
        Missions missions = receiveMissions(names);

        Ladder ladder = makeLadder(names.size());
        printLadder(names, missions, ladder);

        LadderGame ladderGame = LadderGame.of(names, missions, ladder);
        displayResult(ladderGame);
    }

    private Names receiveNames() {
        try {
            return new Names(inputView.readNames());
        } catch (IllegalArgumentException exception) {
            outputView.printExceptionMessage(exception);
            return receiveNames();
        }
    }

    private Missions receiveMissions(Names names) {
        try {
            return Missions.createWithSize(inputView.readMissions(), names.size());
        } catch (IllegalArgumentException exception) {
            outputView.printExceptionMessage(exception);
            return receiveMissions(names);
        }
    }

    private Ladder makeLadder(int nameNumber) {
        int lineNumber = nameNumber - 1;
        return new Ladder(lineNumber, receiveHeight(), ladderGenerator);
    }

    private void printLadder(Names names, Missions missions, Ladder ladder) {
        outputView.printResult(names, ladder, missions);
    }

    private Height receiveHeight() {
        try {
            return new Height(inputView.readHeight());
        } catch (IllegalArgumentException exception) {
            outputView.printExceptionMessage(exception);
            return receiveHeight();
        }
    }

    private void displayResult(LadderGame ladderGame) {
        boolean isRepeatable = true;
        while (isRepeatable) {
            isRepeatable = printResult(ladderGame);
        }
    }

    private boolean printResult(LadderGame ladderGame) {
        String searchWord = inputView.readSearchCommand();
        SearchCommand searchCommand = SearchCommand.from(searchWord);
        if (searchCommand.equals(SearchCommand.SEARCH_ALL)) {
            printAllResult(ladderGame);
        }
        if (searchCommand.equals(SearchCommand.SEARCH_ONE)) {
            printSingleResult(ladderGame, searchWord);
        }
        if (searchCommand.isDone()) {
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    private void printAllResult(LadderGame ladderGame) {
        outputView.printAllResult(ladderGame.findAllResult());
    }

    private void printSingleResult(LadderGame ladderGame, String searchWord) {
        try {
            Result result = ladderGame.findResultBy(searchWord);
            outputView.printSingleResult(result);
        } catch (NoSuchElementException exception) {
            outputView.printExceptionMessage(exception);
        }
    }
}
