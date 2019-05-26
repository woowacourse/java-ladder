package ladder.domain;

import ladder.domain.ladder.Ladder;
import ladder.domain.participant.ParticipantGroup;

import java.util.ArrayList;
import java.util.List;

public class LadderGame {
    private final ParticipantGroup participantGroup;
    private final Ladder ladder;

    public LadderGame(final ParticipantGroup participants, final int ladderHeight) {
        this.participantGroup = participants;
        this.ladder = new Ladder(ladderHeight, participantGroup.getSize());
    }

    public Ladder getLadder() {
        return ladder;
    }

    public Match matchingPoint() {
        List<Integer> order = new ArrayList<>();
        for (int i = 0; i < participantGroup.getSize(); i++) {
            order.add(ladder.getEndPoint(i));
        }
        return new Match(order);
    }
}