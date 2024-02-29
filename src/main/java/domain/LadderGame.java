package domain;

import domain.participants.Name;
import domain.participants.Participants;
import domain.ladder.Ladder;
import domain.result.LadderResult;
import domain.result.Position;
import domain.result.Prizes;
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
        Position lastPosition;
        for (int firstPosition = 0; firstPosition < participants.getParticipantsCount(); firstPosition++) {
            lastPosition = ladderResult.getOneResult(new Position(firstPosition));
            result.put(names.get(firstPosition).getName(), prizes.getParticipantPrize(lastPosition.getPosition()));
        }
        return result;
    }

    public String oneResultOfLadder(String name) {
        Position firstPosition = new Position(participants.checkParticipantOrder(name));
        Position lastPosition = ladderResult.getOneResult(firstPosition);
        return prizes.getParticipantPrize(lastPosition.getPosition());
    }

}
