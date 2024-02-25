package ladder.controller;

import ladder.domain.generator.LadderStepsGenerator;
import ladder.domain.generator.RandomLadderStepsGenerator;
import ladder.domain.ladder.Ladder;
import ladder.domain.ladder.size.LadderSize;
import ladder.domain.outcome.Outcomes;
import ladder.domain.participant.Participants;
import ladder.view.InputView;
import ladder.view.OutputView;

import java.util.List;
import java.util.function.Function;

public class LadderGame {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public void run() {
        final Participants participants = createParticipants();
        final Outcomes outcomes = readOutComes(participants.getCount());
        final int width = participants.getNecessaryLadderWidth();
        final Ladder ladder = createLadder(width);
        printLadder(participants, ladder);
    }

    private Participants createParticipants() {
        try {
            final List<String> participantsName = inputView.readParticipantsName();
            return new Participants(participantsName);
        } catch (IllegalArgumentException e) {
            outputView.printException(e);
            return createParticipants();
        }
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

    private Ladder createLadder(final int ladderWidth) {
        LadderSize ladderSize = retryOnException(this::createLadderSize, ladderWidth);
        final LadderStepsGenerator ladderStepsGenerator = new RandomLadderStepsGenerator(ladderSize);
        return new Ladder(ladderStepsGenerator);
    }

    private LadderSize createLadderSize(final int ladderWidth) {
        final int ladderHeight = inputView.readLadderHeight();
        return new LadderSize(ladderWidth, ladderHeight);
    }

    private void printLadder(final Participants participants, final Ladder ladder) {
        outputView.printResultPrefix();
        outputView.printParticipants(participants);
        outputView.printLadder(ladder);
    }

    private <T, R> R retryOnException(final Function<T, R> retryOperation, T input) {
        try {
            return retryOperation.apply(input);
        } catch (IllegalArgumentException e) {
            outputView.printException(e);
            return retryOnException(retryOperation, input);
        }
    }
}
