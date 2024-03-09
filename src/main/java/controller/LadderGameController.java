package controller;

import java.util.function.Supplier;

import model.*;
import view.InputView;
import view.OutputView;

public class LadderGameController {

    private static final String PRINT_ALL_COMMAND = "all";

    private final InputView inputView;
    private final OutputView outputView;
    private final RandomGenerator generator = new RandomGenerator();

    public LadderGameController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        Participants participants = retryUntilSuccess(inputView::readParticipantNames);
        Prizes prizes = retryUntilSuccess(() -> inputView.readPrizesNames(participants.getSize()));
        Height height = retryUntilSuccess(inputView::readLadderHeight);

        Ladder ladder = new Ladder(height, participants.getSize(), generator);
        LadderResult ladderResult = new LadderResult(participants, prizes, ladder);

        outputView.printGame(participants, prizes, ladder);
        printResult(participants, ladderResult);
    }

    private void printResult(Participants participants, LadderResult ladderResult) {
        String target = inputView.readResultSearch();
        outputView.printResultHeader();
        if (target.equals(PRINT_ALL_COMMAND)) {
            outputView.printEntireResult(ladderResult.getEntireResult());
            return;
        }
        printSoloResult(participants, ladderResult, target);
    }

    private void printSoloResult(Participants participants, LadderResult ladderResult, String name) {
        try {
            Participant target = participants.findTargetParticipant(name);
            Prize result = ladderResult.searchOne(target);
            outputView.printSoloResult(result);
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e.getMessage());
            printResult(participants, ladderResult);
        }
    }

    private <T> T retryUntilSuccess(Supplier<T> supplier) {
        try {
            return supplier.get();
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e.getMessage());
            return retryUntilSuccess(supplier);
        }
    }
}
