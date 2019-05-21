package ladder.domain;

import ladder.domain.ladder.LadderGenerator;
import ladder.domain.participant.ParticipantGroup;
import ladder.domain.ladder.Ladder;
import ladder.domain.reward.RewardGroup;
import ladder.domain.rule.LadderRule;
import ladder.domain.rule.RandomPointLadderRule;

import java.util.ArrayList;
import java.util.List;

public class LadderGame {
    private final ParticipantGroup participantGroup;
    private final Ladder ladder;

    public LadderGame(final ParticipantGroup participants,  final int ladderHeight, final LadderRule ladderRule) {
        this.participantGroup = participants;
        this.ladder = LadderGenerator.generate(participants.getSize(), ladderHeight, ladderRule);
    }

    public LadderGame(final ParticipantGroup participants, final int ladderHeight) {
        this(participants, ladderHeight, new RandomPointLadderRule());
    }

    public Ladder getLadder() {
        return ladder;
    }

    public MatchingResult play() {
        List<Integer> order = new ArrayList<>();
        for (int i = 0; i < participantGroup.getSize(); i++) {
            order.add(ladder.getEndPoint(i));
        }
        return new MatchingResult(order);
    }
}