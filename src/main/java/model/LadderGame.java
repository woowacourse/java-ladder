package model;

public class LadderGame {
    private final Ladder ladder;
    private final Participants participants;
    private final Reward reward;

    public LadderGame(Ladder ladder, Participants participants, Reward reward) {
        this.ladder = ladder;
        this.participants = participants;
        this.reward = reward;
    }

    public String findReward(String participantName){
        return reward.valueOf(ladder.result(participants.getPosition(participantName)));
    }
}
