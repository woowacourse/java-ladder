package controller;

import model.Ladder;
import model.LadderGame;
import model.Participants;
import model.RandomGenerator;
import view.ExceptionHandler;
import view.InputView;
import view.OutputView;

public class LadderGameController {
    private final InputView inputView;
    private final OutputView outputView;
    private final ExceptionHandler exceptionHandler;

    public LadderGameController(InputView inputView, OutputView outputView, ExceptionHandler exceptionHandler) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.exceptionHandler = exceptionHandler;
    }

    public void run() {
        Participants participants = exceptionHandler.retryUntilSuccess(inputView::readParticipantNames);
        int height = exceptionHandler.retryUntilSuccess(inputView::readLadderHeight);

        Ladder ladder = createLadder(height, participants);

        printResult(participants, ladder);
    }

    private Ladder createLadder(int height, Participants participants) {
        RandomGenerator generator = new RandomGenerator();
        LadderGame ladderGame = new LadderGame(height, participants, generator);
        return ladderGame.createLadder();
    }

    private void printResult(Participants participants, Ladder ladder) {
        outputView.printResultHeader();
        outputView.printParticipantsNames(participants);
        outputView.printLadder(ladder);
    }
}
