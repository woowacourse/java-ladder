package ladder.controller;

import ladder.domain.Ladder;
import ladder.domain.Participants;
import ladder.domain.generator.LadderStepGenerator;
import ladder.domain.generator.RandomLadderStepGenerator;
import ladder.view.InputView;

public class LadderGame {
    private final InputView inputView = new InputView();

    public void run() {
        final Participants participants = createParticipants();
        final int participantsCount = participants.getCount();
        final Ladder ladder = createLadder(participantsCount);
    }

    private Participants createParticipants() {
        final String participantsName = inputView.readParticipantsName();
        return new Participants(participantsName);
    }

    private Ladder createLadder(final int participantsCount) {
        final int ladderHeight = inputView.readLadderHeight();
        final LadderStepGenerator ladderStepGenerator = new RandomLadderStepGenerator(participantsCount);
        return new Ladder(ladderStepGenerator, ladderHeight);
    }

    public static void main(String[] args) {
        new LadderGame().run();
    }
}
