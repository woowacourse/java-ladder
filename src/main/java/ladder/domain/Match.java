package ladder.domain;

import ladder.domain.Reward.Reward;
import ladder.domain.Reward.RewardGroup;
import ladder.domain.participant.Participant;
import ladder.domain.participant.ParticipantGroup;

import java.util.*;

public class Match {
    private final Map<Integer, Integer> matchLadderResult;

    public Match(final List<Integer> order) {
        Map<Integer, Integer> matchingResult = new HashMap<>();
        for (int o : order) {
            matchingResult.put(order.indexOf(o), o);
        }
        this.matchLadderResult = matchingResult;
    }

    public LadderGameResult matchLadder(ParticipantGroup participantGroup, RewardGroup rewardGroup) {
        Map<Participant, String> ladderGameResult = new LinkedHashMap<>();
        this.matchLadderResult.entrySet()
                .forEach(x -> ladderGameResult.put(
                        participantGroup.getNthParticipant(x.getKey()),
                        rewardGroup.getNthReward(x.getValue()).toString()
                ));
        return new LadderGameResult(ladderGameResult);
    }

    public Map<Integer,Integer> getMatchingResult(){
        return matchLadderResult;
    }

}
