package controller;

import java.util.function.Supplier;
import model.Ladder;
import model.LadderGame;
import model.Participants;
import model.RandomGenerator;
import view.InputView;
import view.OutputView;

public class LadderGameController {

    private final InputView inputView;
    private final OutputView outputView;
    RandomGenerator generator = new RandomGenerator();

    public LadderGameController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        Participants participants = retryUntilSuccess(inputView::readParticipantNames);
        int height = retryUntilSuccess(inputView::readLadderHeight);

        Ladder ladder = createLadder(height, participants);

        printResult(participants, ladder);
    }

    private Ladder createLadder(int height, Participants participants) {
        LadderGame ladderGame = new LadderGame(height, participants, generator);
        return ladderGame.createLadder();
    }

    private void printResult(Participants participants, Ladder ladder) {
        outputView.printResultHeader();
        outputView.printParticipantsNames(participants);
        outputView.printLadder(ladder);
    }

    private <T> T retryUntilSuccess(Supplier<T> supplier) {
        while (true) {
            try {
                return supplier.get();
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }
}
