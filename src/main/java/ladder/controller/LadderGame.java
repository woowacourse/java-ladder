package ladder.controller;

import ladder.domain.ladder.Height;
import ladder.domain.ladder.Ladder;
import ladder.domain.outcome.Outcomes;
import ladder.domain.participant.Participants;
import ladder.domain.generator.RandomLadderStepGenerator;
import ladder.view.InputView;
import ladder.view.OutputView;

import java.util.List;
import java.util.function.Supplier;

public class LadderGame {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public void run() {
        final Participants participants = retryOnException(this::createParticipants);
        final int width = participants.getNecessaryLadderWidth();
        readOutComes(participants.getCount());
        final Ladder ladder = createLadder(width);
        printLadder(participants, ladder);
    }

    private Participants createParticipants() {
        final List<String> participantsName = inputView.readParticipantsName();
        return new Participants(participantsName);
    }

    private Outcomes readOutComes(int neededOutcomesCount) {
        try {
            List<String> outcomes = inputView.readOutcomes();
            return new Outcomes(outcomes, neededOutcomesCount);
        } catch (IllegalArgumentException e) {
            outputView.printException(e);
            return readOutComes(neededOutcomesCount);
        }
    }

    private Ladder createLadder(final int stepWidth) {
        final Height height = retryOnException(this::readLadderHeight);
        final RandomLadderStepGenerator ladderStepGenerator = new RandomLadderStepGenerator(stepWidth);
        return new Ladder(ladderStepGenerator, height);
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
        try {
            return retryOperation.get();
        } catch (IllegalArgumentException e) {
            outputView.printException(e);
            return retryOnException(retryOperation);
        }
    }
}
