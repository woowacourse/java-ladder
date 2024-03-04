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
        List<Participant> entireParticipant = participants.getParticipants();
        List<Prize> entirePrize = prizes.getPrizes();

        for (int startIndex = 0; startIndex < participants.getSize(); startIndex++) {
            int destination = ladder.climbLadder(startIndex);
            result.put(entireParticipant.get(startIndex), entirePrize.get(destination));
        }
        return result;
    }

    public Prize searchOne(Participant target) {
        return result.get(target);
    }

    public Map<Participant, Prize> getEntireResult() {
        return result;
    }
}
