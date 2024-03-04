package laddergame.controller;

import laddergame.model.executionresults.ExecutionResults;
import laddergame.model.generator.LineConnectionDecisionGenerator;
import laddergame.model.generator.RandomLineConnectionDecisionGenerator;
import laddergame.model.laddergame.LadderGame;
import laddergame.model.laddergame.LadderGameGenerator;
import laddergame.model.laddergame.LadderHeight;
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
        LadderGame ladderGame = getLadderGame(ladderHeight, participants);

        printResult(participants, ladderGame, executionResults);
        InquirySubject inquirySubject = inputView.readInquirySubject(participants);
        ResultProcessor resultProcessor = new ResultProcessor(inquirySubject, executionResults, ladderGame);
        outputView.printGameResults(resultProcessor.getGameResults());
    }

    private LadderGame getLadderGame(LadderHeight ladderHeight, Participants participants) {
        LineConnectionDecisionGenerator randomGenerator = new RandomLineConnectionDecisionGenerator();
        LadderGameGenerator ladderGameGenerator
                = new LadderGameGenerator(ladderHeight, participants, randomGenerator);
        return ladderGameGenerator.getLadderGame();
    }

    private void printResult(Participants participants, LadderGame ladderGame, ExecutionResults executionResults) {
        outputView.printResultHeader();
        outputView.printParticipantsNames(participants);
        outputView.printLadder(ladderGame);
        outputView.printExecutionResults(executionResults);
    }
}
