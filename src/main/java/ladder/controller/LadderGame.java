package ladder.controller;

import ladder.domain.ladder.Ladder;
import ladder.domain.participant.Participants;
import ladder.domain.generator.LadderStepGenerator;
import ladder.domain.generator.RandomLadderStepGenerator;
import ladder.view.InputView;
import ladder.view.OutputView;

import java.util.List;

public class LadderGame {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public void run() {
        final Participants participants = createParticipants();
        final int stepWidth = participants.getCount() - 1;
        final Ladder ladder = createLadder(stepWidth);
        printLadder(participants, ladder);
        inputView.closeResource();
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

    private Ladder createLadder(final int stepWidth) {
        try {
            final int ladderHeight = inputView.readLadderHeight();
            final LadderStepGenerator ladderStepGenerator = new RandomLadderStepGenerator(stepWidth);
            return new Ladder(ladderStepGenerator, ladderHeight);
        } catch (RuntimeException e) {
            outputView.printException(e);
            return createLadder(stepWidth);
        }
    }

    private void printLadder(final Participants participants, final Ladder ladder) {
        outputView.printResultPrefix();
        outputView.printParticipants(participants);
        outputView.printLadder(ladder);
    }
}
