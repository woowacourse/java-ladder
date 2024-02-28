package laddergame.controller;

import laddergame.model.executionresults.ExecutionResults;
import laddergame.model.laddergame.LadderGame;
import laddergame.model.laddergame.LadderHeight;
import laddergame.model.laddergame.RandomLinesGenerator;
import laddergame.model.laddergame.ResultProcessor;
import laddergame.model.participants.InquirySubject;
import laddergame.model.participants.Participants;
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
