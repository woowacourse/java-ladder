package domain;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class LadderGame {

    private final Participants participants;
    private final Prizes prizes;
    private final LadderResult ladderResult;


    public LadderGame(Participants participants, Prizes prizes, Ladder ladder) {
        this.participants = participants;
        this.prizes = prizes;
        this.ladderResult = new LadderResult(ladder, participants.getParticipantsCount());
    }

    public Map<String, String> allResultOfLadder() {
        List<Name> names = participants.getParticipantsName();
        Map<String, String> result = new LinkedHashMap<>();
        for (int i = 0; i < participants.getParticipantsCount(); i++) {
            result.put(names.get(i).getName(), prizes.getParticipantPrize(ladderResult.getOneResult(i)));
        }
        return result;
    }

    public String oneResultOfLadder(String name) {
        int firstPosition = participants.checkParticipantOrder(name);
        return prizes.getParticipantPrize(ladderResult.getOneResult(firstPosition));
    }


}
