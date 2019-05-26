package ladder.domain;

import ladder.domain.Reward.Reward;
import ladder.domain.Reward.RewardGroup;
import ladder.domain.ladder.Ladder;
import ladder.domain.participant.Participant;
import ladder.domain.participant.ParticipantGroup;

import java.util.HashMap;
import java.util.Map;

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

    public LadderGameResult playingGame(ParticipantGroup participantGroup, RewardGroup rewardGroup) {
        Map<Participant, Reward> ladderGameResult = new HashMap<>();
        for (int i = 0; i < participantGroup.getSize(); i++) {
            ladderGameResult.put(participantGroup.getNthParticipant(i), rewardGroup.getNthReward(ladder.getEndPoint(i)));
        }
        return new LadderGameResult(ladderGameResult);
    }
}