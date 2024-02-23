package ladder.controller;

import ladder.domain.ladder.Height;
import ladder.domain.ladder.Ladder;
import ladder.domain.participant.Participants;
import ladder.exception.ExceptionHandler;
import ladder.view.InputView;
import ladder.view.OutputView;

import java.util.List;

public class LadderGame {
    private final InputView inputView;
    private final OutputView outputView;
    private final ExceptionHandler exceptionHandler;

    public LadderGame(
            final InputView inputView,
            final OutputView outputView,
            final ExceptionHandler exceptionHandler) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.exceptionHandler = exceptionHandler;
    }

    public void run() {
        final Participants participants = exceptionHandler.retryOnException(this::createParticipants);
        final int width = participants.getNecessaryLadderWidth();
        final Ladder ladder = createLadder(width);
        printLadder(participants, ladder);
        inputView.closeResource();
    }

    private Participants createParticipants() {
        final List<String> participantsName = inputView.readParticipantsName();
        return new Participants(participantsName);
    }

    private Ladder createLadder(final int stepWidth) {
        final Height height = exceptionHandler.retryOnException(this::readLadderHeight);
        return new Ladder(height, stepWidth);
    }

    private Height readLadderHeight() {
        final int ladderHeight = inputView.readLadderHeight();
        return new Height(ladderHeight);
    }

    private void printLadder(final Participants participants, final Ladder ladder) {
        outputView.printResultPrefix();
        outputView.printParticipants(participants);
        outputView.printLadder(ladder);
    }
}
