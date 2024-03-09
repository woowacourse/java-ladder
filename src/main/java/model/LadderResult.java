package model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LadderResult {
    private final Map<Participant, Prize> result = new HashMap<>();;

    public LadderResult(Participants participants, Prizes prizes, Ladder ladder) {
        List<Participant> entireParticipant = participants.getParticipants();
        List<Prize> entirePrize = prizes.getPrizes();

        for (int startIndex = 0; startIndex < participants.getSize(); startIndex++) {
            int destinationIndex = ladder.climbLadder(startIndex);
            result.put(entireParticipant.get(startIndex), entirePrize.get(destinationIndex));
        }
    }

    public Prize getSpecificResult(Participant target) {
        return result.get(target);
    }

    public Map<Participant, Prize> getAllResult() {
        return result;
    }
}
