package laddergame.model;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Rewards {
    private static final String ERROR_RESULT_PARTICIPANTS_NOT_SAME = "실행결과의 개수는 참여자 인원과 같아야 합니다.";

    private final List<Reward> rewards;

    public Rewards(List<String> results, Participants participants) {
        validateSize(results, participants.getNumber());
        this.rewards = convertToRewardNames(results);
    }

    private static void validateSize(List<String> results, int participantsCount) {
        if (results.size() != participantsCount) {
            throw new IllegalArgumentException(ERROR_RESULT_PARTICIPANTS_NOT_SAME);
        }
    }

    private List<Reward> convertToRewardNames(List<String> results) {
        return results.stream()
            .map(Reward::new)
            .collect(Collectors.toList());
    }

    public List<Reward> getRewardNames() {
        return Collections.unmodifiableList(rewards);
    }

    public Reward getReward(int i) {
        return rewards.get(i);
    }
}
