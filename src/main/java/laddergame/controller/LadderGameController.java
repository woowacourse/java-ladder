package laddergame.controller;

import java.util.List;
import laddergame.model.executionresults.ExecutionResults;
import laddergame.model.laddergame.LadderGame;
import laddergame.model.laddergame.LadderGameGenerator;
import laddergame.model.laddergame.LadderHeight;
import laddergame.model.laddergame.RandomGenerator;
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
        RandomGenerator randomGenerator = new RandomGenerator();
        List<List<Boolean>> doublyBooleans = randomGenerator.generateBooleans(ladderHeight, participants);
        LadderGameGenerator ladderGameGenerator = new LadderGameGenerator(doublyBooleans);
        return ladderGameGenerator.getLadderGame();
    }

    private void printResult(Participants participants, LadderGame ladderGame, ExecutionResults executionResults) {
        outputView.printResultHeader();
        outputView.printParticipantsNames(participants);
        outputView.printLadder(ladderGame);
        outputView.printExecutionResults(executionResults);
    }
}
