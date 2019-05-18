package ladder.domain;

import ladder.domain.ladder.LadderGenerator;
import ladder.domain.participant.ParticipantGroup;
import ladder.domain.ladder.Ladder;
import ladder.domain.reward.RewardGroup;
import ladder.domain.rule.RandomPointLadderRule;

import java.util.ArrayList;
import java.util.List;

public class LadderGame {
    private final ParticipantGroup participantGroup;
    private final RewardGroup rewards;
    private final Ladder ladder;

    public LadderGame(final ParticipantGroup participants, final RewardGroup rewards, int ladderHeight) {
        this.participantGroup = participants;
        this.rewards = rewards;
        this.ladder = LadderGenerator.generate(participants.getSize(), ladderHeight, new RandomPointLadderRule());
    }

    public Ladder getLadder() {
        return ladder;
    }

    public LadderGameResult getGameResult() {
        return new LadderGameResult(participantGroup, rewards, play());
    }

    private List<Integer> play() {
        List<Integer> order = new ArrayList<>();
        for (int i = 0; i < participantGroup.getSize(); i++) {
            order.add(ladder.getEndPoint(i));
        }
        return order;
    }
}