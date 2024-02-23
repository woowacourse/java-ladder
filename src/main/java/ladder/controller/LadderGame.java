package ladder.controller;

import ladder.domain.ladder.Height;
import ladder.domain.ladder.Ladder;
import ladder.domain.participant.Participants;
import ladder.view.InputView;
import ladder.view.OutputView;

import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

public class LadderGame {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public void run() {
        final Participants participants = retryOnException(this::createParticipants);
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
        final Height height = retryOnException(this::readLadderHeight);
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

    private <T> T retryOnException(final Supplier<T> retryOperation) {
        boolean retry = true;
        Optional<T> result = Optional.empty();
        while (retry) {
            result = tryOperation(retryOperation);
            retry = result.isEmpty();
        }
        return result.get();
    }

    private <T> Optional<T> tryOperation(final Supplier<T> operation) {
        try {
            return Optional.of(operation.get());
        } catch (IllegalArgumentException e) {
            outputView.printException(e);
            return Optional.empty();
        }
    }
}
