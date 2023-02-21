package laddergame.model;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import laddergame.model.Ladder.Ladder;

public class LadderGame {
    Map<String, String> matching;

    public LadderGame(Ladder ladder, Rewards rewards, Participants participants) {
        matching = new HashMap<>();
        for (int i = 0; i < participants.getNumber(); i++) {
            String name = participants.getParticipant(i).getName();
            int position = ladder.getRewardPosition(i, participants.getNumber());
            String reward = rewards.getReward(position).getName();
            matching.put(name, reward);
        }
    }

    public String getReward(String name) {
        return matching.get(name);
    }

    public void checkParticipant(String name) {
        if (!name.equals("all") && !matching.containsKey(name)) {
            throw new IllegalArgumentException("참여자명이 올바르지 않습니다.");
        }
    }

    public Map<String, String> getMatching() {
        return Collections.unmodifiableMap(matching);
    }
}
