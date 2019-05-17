package ladder.domain;

import ladder.domain.participant.ParticipantGroup;
import ladder.domain.ladder.Ladder;

import java.util.ArrayList;
import java.util.List;

public class LadderGame {
    private final ParticipantGroup participantGroup;
    private final Rewards rewards;
    private final Ladder ladder;

    public LadderGame(final ParticipantGroup participants, final Rewards rewards, int ladderHeight) {
        this.participantGroup = participants;
        this.rewards = rewards;
        this.ladder = new Ladder(ladderHeight, participantGroup.getSize());
    }

    public Ladder getLadder() {
        return ladder;
    }

    public LadderGameResult getGameResult() {
        return new LadderGameResult(participantGroup, rewards, makeLadderResult());
    }

    public List<Integer> makeLadderResult() {
        List<Integer> order = new ArrayList<>();
        for (int i = 0; i < participantGroup.getSize(); i++) {
            order.add(ladder.getEndPoint(i));
        }
        return order;
    }
}