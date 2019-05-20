package ladder.domain;

import ladder.domain.participant.Participant;
import ladder.domain.participant.ParticipantGroup;
import ladder.domain.reward.Reward;
import ladder.domain.reward.RewardGroup;

import java.util.*;

public class MatchingResult {
    private Map<Integer, Integer> matchingResult;

    MatchingResult(List<Integer> tmps) {
        Map<Integer, Integer> matchingResult = new HashMap<>();
        for (int tmp : tmps) {
            matchingResult.put(tmps.indexOf(tmp), tmp);
        }
        this.matchingResult = Collections.unmodifiableMap(matchingResult);
    }

    public LadderGameResult map(ParticipantGroup participants, RewardGroup rewards) {
        validateMappingInformation(participants, rewards);

        Map<Participant, Reward> ladderGameResult = new LinkedHashMap<>();
        this.matchingResult.entrySet()
                .forEach(x -> ladderGameResult.put(
                        participants.getNthParticipant(x.getKey()),
                        rewards.getNthReward(x.getValue())
                ));
        return new LadderGameResult(ladderGameResult);
    }

    private void validateMappingInformation(ParticipantGroup participants, RewardGroup rewards) {
        if (participants == null || rewards == null) {
            throw new IllegalArgumentException();
        }
        if (participants.getSize() != matchingResult.size()
                || rewards.getSize() != matchingResult.size()) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MatchingResult result = (MatchingResult) o;
        return matchingResult.equals(result.matchingResult);
    }

    @Override
    public int hashCode() {
        return Objects.hash(matchingResult);
    }
}
