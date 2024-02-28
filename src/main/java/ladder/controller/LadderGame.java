package ladder.controller;

import ladder.domain.generator.LadderStepsGenerator;
import ladder.domain.generator.RandomLadderStepsGenerator;
import ladder.domain.ladder.Ladder;
import ladder.domain.ladder.ParticipantsOutcome;
import ladder.domain.ladder.size.LadderSize;
import ladder.domain.outcome.Outcomes;
import ladder.domain.participant.Participants;
import ladder.view.InputView;
import ladder.view.OutputView;

import java.util.List;
import java.util.function.Supplier;

public class LadderGame {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public void run() {
        final Participants participants = retryOnException(this::createParticipants);
        final Outcomes outcomes = retryOnException(() -> readOutcomes(participants.getCount()));
        final int width = participants.getNecessaryLadderWidth();
        final Ladder ladder = createLadder(width);
        printLadderGame(participants, ladder, outcomes);

        final ParticipantsOutcome participantsOutcome = participants.assignOutcomesByLadder(ladder, outcomes);
        runUntilNoException(() -> printParticipantsOutcome(participantsOutcome));
    }

    private Participants createParticipants() {
        final List<String> participantsName = inputView.readParticipantsName();
        return new Participants(participantsName);
    }

    private Outcomes readOutcomes(final int neededOutcomesCount) {
        final List<String> outcomes = inputView.readOutcomes();
        return new Outcomes(outcomes, neededOutcomesCount);
    }

    private Ladder createLadder(final int ladderWidth) {
        LadderSize ladderSize = retryOnException(() -> createLadderSize(ladderWidth));
        final LadderStepsGenerator ladderStepsGenerator = new RandomLadderStepsGenerator(ladderSize);
        return new Ladder(ladderStepsGenerator);
    }

    private LadderSize createLadderSize(final int ladderWidth) {
        final int ladderHeight = inputView.readLadderHeight();
        return new LadderSize(ladderWidth, ladderHeight);
    }

    private void printLadderGame(final Participants participants, final Ladder ladder, final Outcomes outcomes) {
        outputView.printResultPrefix();
        outputView.printParticipants(participants);
        outputView.printLadder(ladder);
        outputView.printOutcomes(outcomes);
    }

    private void printParticipantsOutcome(final ParticipantsOutcome participantsOutcome) {
        final String requiredOutcome = inputView.readRequiredOutcome();
        outputView.printParticipantsOutcome(participantsOutcome, requiredOutcome);
    }

    private void runUntilNoException(final Runnable operation) {
        boolean isExceptionOccurred = false;
        while (!isExceptionOccurred) {
            isExceptionOccurred = runAndCheckExceptionOccurred(operation);
        }
    }

    private boolean runAndCheckExceptionOccurred(final Runnable operation) {
        try {
            operation.run();
            return false;
        } catch (IllegalArgumentException e) {
            return true;
        }
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
