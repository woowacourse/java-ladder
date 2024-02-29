package model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LadderResult {
    private Map<Participant, Prize> result;

    public LadderResult(Participants participants, Prizes prizes, Ladder ladder) {
        this.result = generateResult(participants, prizes, ladder);
    }

    private Map<Participant, Prize> generateResult(Participants participants, Prizes prizes, Ladder ladder) {
        result = new HashMap<>();
        int index = 0;
        for (Participant participant : participants.getParticipants()) {
            int destination = ladder.climbLadder(index);
            result.put(participant, prizes.getPrizes().get(destination));
            index++;
        }

        return result;
    }

    public Prize searchOne(Participant target) {
        return result.get(target);
    }

    public List<Prize> searchAll(List<Participant> participants) {
        return participants.stream()
                .map(result::get)
                .toList();
    }
}
