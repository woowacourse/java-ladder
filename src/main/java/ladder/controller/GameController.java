package ladder.controller;

import ladder.domain.Result;
import ladder.domain.ladder.Ladder;
import ladder.domain.Participant;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class GameController {
    private static final int MIN_PARTICIPANTS_NUMBER = 2;
    private List<Participant> participants;
    private List<String> rewards;
    private List<Integer> ladderResultNumbers;
    private Ladder ladder;
    private Result result;

    public void registParticipant(List<String> participants) {
        this.participants = new ArrayList<>();
        validateMinParticipants(participants);
        validateDuplicatedParticipants(participants);
        participants.stream().forEach(x -> this.participants.add(new Participant(x)));
    }

    private void validateMinParticipants(List<String> participants) {
        if (participants.size() < MIN_PARTICIPANTS_NUMBER) {
            throw new IllegalArgumentException("참가자는 2명 이상이어야 합니다.");
        }
    }

    private void validateDuplicatedParticipants(List<String> participants) {
        if (participants.size() != new HashSet<>(participants).size()) {
            throw new IllegalArgumentException("참가자 명은 중복될 수 업습니다.");
        }
    }

    public void resistRewards(List<String> rewards) {
        validateRewards(rewards);
        this.rewards = rewards;
    }

    private void validateRewards(List<String> rewards) {
        if (rewards.size() != participants.size()) {
            throw new IllegalArgumentException("참가자 수와 일치하지 않습니다.");
        }
    }

    public void makeLadder(int height) {
        ladder = new Ladder(height, participants.size());
        getLadderResult();
    }

    public Ladder getLadder() {
        return ladder;
    }

    public List<String> getRewards() {
        return rewards;
    }

    public List<Participant> getParticipants() {
        return participants;
    }

    private void getLadderResult() {
        ladderResultNumbers = new ArrayList<>();
        participants.stream().forEach(x -> ladderResultNumbers.add(ladder.getEndPoint(participants.indexOf(x))));
    }

    public Result getGameResult() {
        result = new Result(participants, rewards, ladderResultNumbers);
        return result;
    }

    public boolean getGameEnd() {
        return result.getIsEnd();
    }
}
