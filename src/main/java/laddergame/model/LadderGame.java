package laddergame.model;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

import laddergame.model.Ladder.Ladder;

public class LadderGame {
    public static final String ALL_MATCHING_KEY = "all";
    private static final String ERROR_MATCHING_KEY = "참여자명이 올바르지 않습니다.";

    private final Map<Participant, Reward> matching;

    public LadderGame(Ladder ladder, Rewards rewards, Participants participants) {
        this.matching = new LinkedHashMap<>();
        rideLadder(ladder, rewards, participants);
    }

    private void rideLadder(Ladder ladder, Rewards rewards, Participants participants) {
        for (int i = 0; i < participants.getNumber(); i++) {
            Participant participant = participants.gerParticipant(i);
            int position = ladder.getParticipantPosition(i);
            Reward reward = rewards.getReward(position);
            this.matching.put(participant, reward);
        }
    }

    public void checkParticipant(String name) {
        matching.keySet()
            .stream()
            .filter(participant -> ALL_MATCHING_KEY.equals(name) || participant.getName().equals(name))
            .findAny()
            .orElseThrow(() -> new IllegalArgumentException(ERROR_MATCHING_KEY));
    }

    public String getReward(String name) {
        Reward reward = matching.get(new Participant(name));
        return reward.getName();
    }

    public Map<Participant, Reward> getMatching() {
        return Collections.unmodifiableMap(matching);
    }
}
