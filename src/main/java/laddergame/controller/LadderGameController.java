package laddergame.controller;

import laddergame.model.ExecutionResults;
import laddergame.model.InquirySubject;
import laddergame.model.LadderGame;
import laddergame.model.LadderHeight;
import laddergame.model.Participants;
import laddergame.model.RandomLinesGenerator;
import laddergame.model.ResultProcessor;
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
        LadderGame ladderGame = new RandomLinesGenerator().getLadderGame(ladderHeight, participants);

        printResult(participants, ladderGame, executionResults);
        InquirySubject inquirySubject = inputView.readInquirySubject(participants);
        ResultProcessor resultProcessor = new ResultProcessor(inquirySubject, executionResults, ladderGame);
        outputView.printGameResults(resultProcessor.getGameResults());
    }

    private void printResult(Participants participants, LadderGame ladderGame, ExecutionResults executionResults) {
        outputView.printResultHeader();
        outputView.printParticipantsNames(participants);
        outputView.printLadder(ladderGame);
        outputView.printExecutionResults(executionResults);
    }
}
