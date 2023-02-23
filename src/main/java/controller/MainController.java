package controller;

import domain.LadderGame;
import domain.Result;
import domain.SearchCommand;
import domain.generator.BooleanGenerator;
import domain.ladder.Height;
import domain.ladder.Lines;
import domain.mission.Missions;
import domain.player.Names;
import domain.player.Players;
import view.InputView;
import view.OutputView;

public class MainController {

    private final InputView inputView;
    private final OutputView outputView;
    private final BooleanGenerator booleanGenerator;


    public MainController(InputView inputView, OutputView outputView, BooleanGenerator booleanGenerator) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.booleanGenerator = booleanGenerator;
    }

    public void start() {
        Names names = receiveNames();
        Missions missions = receiveMissions(names.size());

        Lines ladder = makeLadder(names.getPersonNumber());
        printLadder(names, missions, ladder);

        LadderGame ladderGame = LadderGame.of(new Players(names), missions, ladder);
        displayResult(ladderGame);
    }

    private void displayResult(LadderGame ladderGame) {
        boolean isRepeatable = Boolean.TRUE;
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
            Result result = ladderGame.findResultByName(searchWord);
            outputView.printSingleResult(result);
        } catch (IllegalArgumentException exception) {
            outputView.printExceptionMessage(exception);
        }
    }

    private void printLadder(Names names, Missions missions, Lines lines) {
        outputView.printResult(names, lines, missions);
    }

    private Lines makeLadder(int nameNumber) {
        int lineNumber = nameNumber - 1;
        return new Lines(lineNumber, receiveHeight().getHeight(), booleanGenerator);
    }

    private Names receiveNames() {
        try {
            return new Names(inputView.readNames());
        } catch (IllegalArgumentException exception) {
            outputView.printExceptionMessage(exception);
            return receiveNames();
        }
    }

    private Missions receiveMissions(int size) {
        try {
            return new Missions(inputView.readMissions(), size);
        } catch (IllegalArgumentException exception) {
            outputView.printExceptionMessage(exception);
            return receiveMissions(size);
        }
    }

    private Height receiveHeight() {
        try {
            return new Height(inputView.readHeight());
        } catch (IllegalArgumentException exception) {
            outputView.printExceptionMessage(exception);
            return receiveHeight();
        }
    }

}
