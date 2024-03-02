package ladder.domain.ladderGame;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import ladder.domain.participant.Name;
import ladder.domain.participant.Participants;
import ladder.domain.prize.GamePrizes;

public class ResultFinder {

    private final Participants participants;
    private final GamePrizes gamePrizes;
    private final LadderMapper ladderMapper;

    public ResultFinder(Participants participants, GamePrizes gamePrizes, LadderMapper ladderMapper) {
        this.participants = participants;
        this.gamePrizes = gamePrizes;
        this.ladderMapper = ladderMapper;
    }

    public Map<String, String> findAllPrizes() {
        Map<String, String> foundPrize = new HashMap<>();

        for (Name name : participants.getNames()) {
            foundPrize.put(name.getName(), findPrize(name));
        }
        return Collections.unmodifiableMap(foundPrize);
    }

    public String findPrize(Name name) {
        int position = participants.findNamePosition(name);
        int prizePosition = ladderMapper.getEndPosition(position);
        return gamePrizes.findPrize(prizePosition);
    }
}
