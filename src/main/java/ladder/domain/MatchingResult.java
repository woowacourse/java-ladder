package ladder.domain;

import ladder.domain.participant.Participant;
import ladder.domain.participant.ParticipantGroup;
import ladder.domain.reward.Reward;
import ladder.domain.reward.RewardGroup;

import java.util.*;

public class MatchingResult {
    private final Map<Integer, Integer> matchingResult;

    MatchingResult(final List<Integer> result) {
        Map<Integer, Integer> matchingResult = new HashMap<>();
        result.forEach(x -> matchingResult.put(result.indexOf(x), x));
        this.matchingResult = Collections.unmodifiableMap(matchingResult);
    }

    public LadderGameResult map(final ParticipantGroup participants, final RewardGroup rewards) {
        validateMappingInformation(participants, rewards);

        Map<Participant, Reward> ladderGameResult = new LinkedHashMap<>();
        this.matchingResult.entrySet()
                .forEach(x -> ladderGameResult.put(
                        participants.getNthParticipant(x.getKey()),
                        rewards.getNthReward(x.getValue())
                ));
        return new LadderGameResult(ladderGameResult);
    }

    private void validateMappingInformation(final ParticipantGroup participants, final RewardGroup rewards) {
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
