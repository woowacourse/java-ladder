package laddergame.controller;

import laddergame.model.ExecutionResults;
import laddergame.model.LadderGame;
import laddergame.model.LadderHeight;
import laddergame.model.Participants;
import laddergame.model.RandomLinesGenerator;
import laddergame.view.InputView;
import laddergame.view.OutputView;

public class LadderGameController {
    private final InputView inputView;
    private final OutputView outputView;

    public LadderGameController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        Participants participants = inputView.readParticipantNames();
        ExecutionResults executionResults = inputView.readExecutionResults(participants);
        LadderHeight ladderHeight = inputView.readLadderHeight();

        RandomLinesGenerator randomGenerator = new RandomLinesGenerator();
        LadderGame ladderGame = randomGenerator.getLadderGame(ladderHeight, participants);

        printResult(participants, ladderGame, executionResults);
    }

    private void printResult(Participants participants, LadderGame ladderGame, ExecutionResults executionResults) {
        outputView.printResultHeader();
        outputView.printParticipantsNames(participants);
        outputView.printLadder(ladderGame);
        outputView.printExecutionResults(executionResults);
    }
}
