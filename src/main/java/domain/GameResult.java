package domain;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class GameResult {

    private final Map<Participant, String> participantsResult = new HashMap<>();

    public void recordParticipantsResult(Participant participant, Prizes prizes, int position) {
        participantsResult.put(participant, prizes.getPrizeByPosition(position));
    }

    public String getResultByParticipant(Participant participant) {
        return participantsResult.get(participant);
    }

    public Map<Participant, String> getParticipantsResult() {
        return Collections.unmodifiableMap(participantsResult);
    }
}
