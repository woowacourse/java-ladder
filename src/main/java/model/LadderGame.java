package model;

import java.util.LinkedHashMap;
import java.util.Map;

public class LadderGame {
    private final Ladder ladder;
    private final Participants participants;
    private final Reward reward;

    public LadderGame(Ladder ladder, Participants participants, Reward reward) {
        this.ladder = ladder;
        this.participants = participants;
        this.reward = reward;
    }

    public String findReward(Participant participant){
        return reward.valueOf(ladder.result(participants.getPosition(participant)));
    }

    public Map<Participant, String> findAllReward(){
        Map<Participant, String> rewards = new LinkedHashMap<>();
        for (Participant participant : participants.getParticipants()){
            rewards.put(participant, reward.valueOf(
                    ladder.result(participants.getPosition(participant)))
            );
        }
        return rewards;
    }
}
